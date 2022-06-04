package domain.customer.controller;

import domain.contract.entity.Contract;
import domain.customer.dto.request.*;
import domain.customer.entity.Customer;
import domain.customer.entity.FindPayment;
import domain.customer.exception.excution.CheckMenuNumberException;
import domain.customer.service.CustomerService;
import domain.employee.controller.EmployeeController;
import domain.insurance.entity.Insurance;
import global.util.Choice;
import global.util.CustomerComment;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class CustomerController {

    private final CustomerService customerService;
    private final Choice choice;
    private final CustomerComment customerComment;

    public CustomerController(Choice choice) {
        this.customerService = new CustomerService();
        this.choice = choice;
        this.customerComment = new CustomerComment();
    }
    //시작화면
    public void initial() {
        switch(customerComment.customerInitial()){
            case 1: //1.로그인
                login();
                break;
            case 2: //2.회원가입
                join();
                break;
            case 3: //3.상담사 연결
                connectSalesEmployee();
                break;
            case 4: //4.종료
                System.exit(0);
                break;
            default:
                new CheckMenuNumberException();
                initial();
                break;
        }
    }
    //로그인 후 관심자화면
    private void enterInterest(Customer customer) {
        System.out.println(customer.getName() + "님 안녕하세요!");
        switch (customerComment.afterLoginInterest()){
            case 1: //1. 상담사 연결하기
                connectSalesEmployee(customer);
                break;
            case 2: //2. 상담사 평가하기
                evaluateSatisfaction(customer);
                break;
            case 3: //3. 보험 가입하기
                if(customerService.checkConnection(customer)!=null) joinInsurance(customer);
                break;
            case 4: //4. 로그아웃
                initial();
                break;
            default:
                new CheckMenuNumberException();
                break;
        }
        enterInterest(customer);
    }

    //로그인 후 고객화면
    public void enter(Customer customer){
        System.out.println(customer.getName() + "님 안녕하세요!");
        switch (customerComment.afterLogin()){
            case 1: //1. 상담사 연결하기
                connectSalesEmployee();
                break;
            case 2: //2. 상담사 평가하기
                evaluateSatisfaction(customer);
                break;
            case 3: //3. 가입된 보험 조회하기
                ArrayList<Insurance> insuranceArrayList = findJoinedInsurances(customer.getCustomerId());
                if(insuranceArrayList.isEmpty()==false) {
                    customerComment.joinedInsurances(insuranceArrayList);
                    afterfindJoinedInsurances(customer);
                }
                break;
            case 4: //4. 보험급 납부내역
                ArrayList<FindPayment> findPayment = findPaymentHistory(customer.getCustomerId());
                if(findPayment!=null) customerComment.findPaymentHistory(findPayment);
                break;
            case 5: //5. 사고 처리 접수
                incidentHandling(customer);
                break;
            case 6: //6. 보험 가입하기
                joinInsurance(customer);
                break;
            case 7: //7. 보험금 청구하기
                claimInsurance(customer);
                break;
            case 8: //8. 로그아웃
                initial();
                break;
            default:
                new CheckMenuNumberException();
                break;
        }
        enter(customer);
    }

    //보험 목록 확인 후 화면
    private void afterfindJoinedInsurances(Customer customer) {
        switch(customerComment.afterfindJoinedInsurances()) {
            case 1: //1.보험 해지하기
                String cancelInsuranceId = choice.getId();
                //보험 해지 진행
                break;
            case 2: //2. 돌아가기
                enter(customer);
                break;
            default:
                new CheckMenuNumberException();
                break;
        }
    }

    //로그인
    public void login() {
        String id = choice.getId();
        String pw = choice.getPassword();

        CustomerLoginRequest customerLoginRequest
                = new CustomerLoginRequest(id, pw);
            Customer customer = customerService.login(customerLoginRequest);
            if(customer != null){
                //관심자
                if(customer.getAddress() == null) {
                    enterInterest(customer);
                } else enter(customer);
            } else login();
    }

    //상담사 만족도 평가
    private void evaluateSatisfaction(Customer customer) {
        if(customerService.checkSatisfaction(customer.getCustomerId()) != null) {
            String satisfaction = choice.getSatisfaction();
            customerService.evaluateSatisfaction(satisfaction, customer.getCustomerId());
            System.out.println(customer.getName() + "님 만족도 평가에 참여해주셔서 감사합니다");
        }
    }

    //보험금 납부 내역
    private ArrayList<FindPayment> findPaymentHistory(String id) {
        return customerService.findPayment(id);
    }

    //가입 보험 내역
    private ArrayList<Insurance> findJoinedInsurances(String id) {
        return customerService.findJoinedInsurances(id);
    }

    //관심자 상담사 연결
    private void connectSalesEmployee() {
        String customerId = choice.getId();
        String password = choice.getPassword();
        String name = choice.getName();
        String phoneNumber = choice.getPhoneNumber();
        int kindOfJob = choice.getKindOfJob();
        int kindOfInsuranceId = choice.getKindOfInsuranceId();

        Customer interestCustomer = new Customer(
                customerId,
                password,
                name,
                null,
                null,
                null,
                null,
                phoneNumber,
                kindOfJob,
                kindOfInsuranceId
        );
        connectSalesEmployee(interestCustomer);
    }

    // 상담사 연결
    private void connectSalesEmployee(Customer customer) {
        customerService.connectSalesEmployee(customer);
        System.out.println(customer.getName()+"님 상담 요청이 완료되었습니다. 빠른 시일 내에 연락드리겠습니다.");
    }

    //회원가입(고객)
    public void join() {
        String customerId = choice.getId();
        if(customerService.checkIdExist(customerId) == 0) {
            String password = choice.getPassword();
            String name = choice.getName();
            String address = choice.getAddress();
            String detailAddress = choice.getDetailAddress();
            String zipcode = choice.getZipcode();
            String email = choice.getEmail();
            String phoneNumber = choice.getPhoneNumber();
            int kindOfJob = choice.getKindOfJob();
            int kindOfInsuranceId = choice.getKindOfInsuranceId();

            CustomerJoinRequest customer = new CustomerJoinRequest(
                    customerId,
                    password,
                    name,
                    address,
                    detailAddress,
                    zipcode,
                    email,
                    phoneNumber,
                    kindOfJob,
                    kindOfInsuranceId
            );
            customerService.join(customer);
            System.out.println("회원가입이 완료되었습니다.");
            initial();
        } else {
            join();
        }

    }

    //보험 가입
    private void joinInsurance(Customer customer) {
        ArrayList<Insurance> interestInsuranceArrayList = customerService.findInterestInsurance(customer);
        String joinInsuranceId = customerComment.interestInsurances(interestInsuranceArrayList);
        if(customer.getAddress()==null) addCustomerInformation(customer);
        //추가정보받아오기
        /*
        PolicyholderJoinRequest policyholderJoinRequest = new PolicyholderJoinRequest(
                policyholderId, customerId, contractId, healthInformationId, creditInformationId
        )
        HealthInformationRequest healthInformationRequest = new HealthInformationRequest(
               healthInformationId, cancer, smoke, alchohol
        )
        */
        this.joinPayer(customer);
        this.joinBeneficiary(customer);
        Contract contract = new Contract(
                customerService.getContractId(),
                customer.getCustomerId(),
                null,
                joinInsuranceId,
                null,
                null,
                null
        );
        EmployeeController.doInsuranceContract(contract);
    }

    private void addCustomerInformation(Customer interestCustomer) {
        String name = choice.getName();
        String address = choice.getAddress();
        String detailAddress = choice.getDetailAddress();
        String zipcode = choice.getZipcode();
        String email = choice.getEmail();
        int kindOfJob = choice.getKindOfJob();
        InterestCustomerJoinRequest customer = new InterestCustomerJoinRequest(
                name,
                address,
                detailAddress,
                zipcode,
                email,
                kindOfJob
        );
        customerService.addCustomerInformation(customer, interestCustomer.getCustomerId());
    }

    //Payer 설정
    private void joinPayer(Customer customer) {
        String payerId;
        if(customerComment.checkBeneficiary()==1) payerId = choice.getId();
        else payerId = customer.getCustomerId();
        String account = choice.getAccount();
        customerService.joinPayer(payerId, account, customer);
    }

    //Beneficiary 설정
    private void joinBeneficiary(Customer customer) {
        String beneficiaryId;
        if(customerComment.checkBeneficiary()==1) beneficiaryId = choice.getId();
        else beneficiaryId = customer.getCustomerId();
        String account = choice.getAccount();
        customerService.joinBeneficiary(beneficiaryId, account, customer);
    }

    //보험금 청구하기
    private void claimInsurance(Customer customer) {
        if(customerService.checkJoinLifeInsurance(customer)!=null) {
            CustomerClaimInsuranceRequest claimInsurance = null;
            try {
                claimInsurance = new CustomerClaimInsuranceRequest(
                        customer.getCustomerId(),
                        choice.getclaimContent(),
                        choice.getclaimCost()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
            customerService.claimInsurance(claimInsurance, customer);
        }
    }

    //사고 처리 접수
    private void incidentHandling(Customer customer) {
        if(customerService.checkJoinNonlifeInsurance(customer)!=null) {
            CustomerHandleIncidentRequest incidentHandling = null;
            try {
                incidentHandling = new CustomerHandleIncidentRequest(
                        customer.getCustomerId(),
                        choice.getIncidentDate(),
                        choice.getCarNumber(),
                        choice.getIncidentSite()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
            customerService.handleIncident(incidentHandling);
        }
    }
}
