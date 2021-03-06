package domain.customer.controller;

import domain.contract.entity.Contract;
import domain.customer.dto.request.*;
import domain.customer.entity.Customer;
import domain.customer.entity.FindPayment;
import domain.customer.exception.excution.CheckMenuNumberException;
import domain.customer.service.CustomerService;
import domain.employee.controller.EmployeeController;
import domain.insurance.entity.Insurance;
import global.util.CustomerComment;

import java.util.ArrayList;

public class CustomerController {

    private final CustomerService customerService;
    private final CustomerComment customerComment;

    public CustomerController() {
        this.customerService = new CustomerService();
        this.customerComment = new CustomerComment();
    }

    //시작화면
    public void initial() {
        Exit:
        while(true){
            switch (customerComment.customerInitial()){
                case 1 :
                    login(); // 1.로그인
                    break;
                case 2 :
                    join(); //2.회원가입
                    break;
                case 3 :
                    connectSalesEmployee();//3.상담사 연결
                    break;
                case 0 :
                    break Exit; //0.종료
                default : {
                    new CheckMenuNumberException();
                    break;
                }
            }
        }
    }

    private void login() {
        Customer customer = getCustomer();
        if(customer != null){//회원이 맞는 경우
            //근데 주소 정보가 없다면 보험 관심자 화면으로 간다.
            if(customer.isInterester()) enterInteresterView(customer);
            else enterCustomer(customer);
        }
    }

    //언액티비티 액티비티로, 대기중 PASS로
    //로그인
    public Customer getCustomer() {
            String id = customerComment.getId();
            String pw = customerComment.getPassword();
            CustomerLoginRequest customerLoginRequest = new CustomerLoginRequest(id, pw);
            return customerService.login(customerLoginRequest);
    }
    //관심자 상담사 연결

    //로그인 후 관심자화면
    private void enterInteresterView(Customer customer) {
        customerComment.greetToCustomer(customer.getName());
        Exit:
        while(true){
            switch (customerComment.afterLoginInterest()){
                case 1: //1. 상담사 연결하기
                    connectSalesEmployee(customer);
                    break;
                case 2: //2. 상담사 평가하기
                    evaluateSatisfaction(customer);
                    break;
                case 3: //3. 보험 가입하기
                    if(customerService.checkConnection(customer)!=null) joinInsurance(customer);
                    System.out.println("보험 가입 완료");
                    break;
                case 4: //4. 로그아웃
                    break Exit;
                default:
                    new CheckMenuNumberException();
                    break;
            }
        }
    }

    //로그인 후 고객화면
    public void enterCustomer(Customer customer){
        customerComment.greetToCustomer(customer.getName());
        Exit:
        while(true){
            switch (customerComment.afterLogin()) {
                case 1 :
                    connectSalesEmployee(customer);//1. 상담사 연결하기
                    break;
                case 2 :
                    evaluateSatisfaction(customer);//2. 상담사 평가하기
                    break;
                case 3 :
                    getJoinedInsurances(customer);//3. 가입된 보험 조회하기
                    break;
                case 4 :
                    printPaymentHistory(customer);//4. 보험급 납부내역
                    break;
                case 5 :
                    incidentHandling(customer);//5. 사고 처리 접수
                    break;
                case 6 :
                    joinInsurance(customer); //6. 보험 가입하기
                    break;
                case 7 :
                    claimInsurance(customer);//7. 보험금 청구하기
                    break;
                case 8 :
                    break Exit;//8. 로그아웃
                default :
                    new CheckMenuNumberException();
                    break;
            }
        }
    }

    private void printPaymentHistory(Customer customer) {
        ArrayList<FindPayment> findPayment = findPaymentHistory(customer.getCustomerId());
        if (findPayment != null) customerComment.findPaymentHistory(findPayment);
    }

    private void getJoinedInsurances(Customer customer) {
        ArrayList<Insurance> insuranceArrayList = findJoinedInsurances(customer.getCustomerId());
        if (!insuranceArrayList.isEmpty()) {
            customerComment.joinedInsurances(insuranceArrayList);
            afterFindJoinedInsurances(customer);
        }
    }

    //보험 목록 확인 후 화면
    private void afterFindJoinedInsurances(Customer customer) {
        Exit:
        while(true){
            switch(customerComment.printJoinedInsurances()) {
                case 1 :
                    cancelInsurance();
                    break;
                case 2 :
                    break Exit;
                default :
                    new CheckMenuNumberException();
                    break;
            }
        }
    }

    private void cancelInsurance() {
        String cancelInsuranceId = customerComment.getId();
    }


    //상담사 만족도 평가
    private void evaluateSatisfaction(Customer customer) {
        if(customerService.checkSatisfaction(customer.getCustomerId()) == null) {
            String satisfaction = customerComment.getSatisfaction();
            customerService.evaluateSatisfaction(satisfaction, customer.getCustomerId());
            customerComment.thanksForEvaluation(customer.getName());
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
        String customerId = customerComment.getId();
        String password = customerComment.getPassword();
        String name = customerComment.getName();
        String phoneNumber = customerComment.getPhoneNumber();
        int kindOfJob = customerComment.getKindOfJob();
        int kindOfInsuranceId = customerComment.getKindOfInsuranceId();

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
                kindOfInsuranceId,
                null
        );
        connectSalesEmployee(interestCustomer);
    }

    // 상담사 연결
    private void connectSalesEmployee(Customer customer) {
        customerService.connectSalesEmployee(customer);
        customerComment.notifyCompleteConsultRequest(customer.getName());
    }

    //회원가입(고객)
    public void join() {
        String customerId = customerComment.getId();
        if(customerService.checkIdExist(customerId) == 0) {
            String password = customerComment.getPassword();
            String name = customerComment.getName();
            String address1 = customerComment.getAddress1();
            String address2 = customerComment.getAddress2();
            String address = address1+address2;
            String detailAddress1 = customerComment.getDetailAddress1();
            String detailAddress2 = customerComment.getDetailAddress2();
            String detailAddress = detailAddress1 + detailAddress2;
            String zipcode = customerComment.getZipcode();
            String email = customerComment.getEmail();
            String phoneNumber = customerComment.getPhoneNumber();
            int kindOfJob = customerComment.getKindOfJob();
            int kindOfInsuranceId = customerComment.getKindOfInsuranceId();
            String ssn = customerComment.getSsn();

            String cancer = customerComment.getCancer();
            String smoke = customerComment.getSmoke();
            String alcohol = customerComment.getAlcohol();



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
                    kindOfInsuranceId,
                    ssn,
                    customerService.getHealthInfo(cancer,smoke,alcohol)
            );
            customerService.join(customer);
            customerComment.notifyCompleteJoining(name);
            initial();
        } else join();
    }

    //보험 가입
    private void joinInsurance(Customer customer){
        ArrayList<Insurance> interestInsuranceArrayList = customerService.findInterestInsurance(customer);
        String joinInsuranceId = customerComment.interestInsurances(interestInsuranceArrayList);
        if(customer.getAddress()==null) addCustomerInformation(customer);
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
        EmployeeController employeeController = new EmployeeController();
        employeeController.makeInsuranceContract(contract);
    }

    private void addCustomerInformation(Customer interestCustomer){
        String address = customerComment.getAddress();
        String detailAddress = customerComment.getDetailAddress();
        String zipcode = customerComment.getZipcode();
        String email = customerComment.getEmail();
        InterestCustomerJoinRequest customer = new InterestCustomerJoinRequest(
                address,
                detailAddress,
                zipcode,
                email
        );
        customerService.addCustomerInformation(customer, interestCustomer.getCustomerId());
    }

    //Payer 설정
    private void joinPayer(Customer customer) {
        String payerId;
        if(customerComment.checkPayer()==1) payerId = customerComment.getId();
        else payerId = customer.getCustomerId();
        String account = customerComment.getAccount();
        customerService.joinPayer(payerId, account, customer);
    }

    //Beneficiary 설정
    private void joinBeneficiary(Customer customer) {
        String beneficiaryId;
        if(customerComment.checkBeneficiary()==1) beneficiaryId = customerComment.getId();
        else beneficiaryId = customer.getCustomerId();
        String account = customerComment.getAccount();
        customerService.joinBeneficiary(beneficiaryId, account, customer);
    }

    //보험금 청구하기
    private void claimInsurance(Customer customer) {
        String contractId = customerService.checkJoinLifeInsurance(customer);
        if(contractId!=null) {
            CustomerClaimInsuranceRequest claimInsurance = null;
            try {
                claimInsurance = new CustomerClaimInsuranceRequest(
                        customer.getCustomerId(),
                        customerComment.getClaimContent(),
                        customerComment.getClaimCost(),
                        contractId
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
            customerService.claimInsurance(claimInsurance, customer);
        }
    }

    //사고 처리 접수
    private void incidentHandling(Customer customer) {
            CustomerHandleIncidentRequest incidentHandling = null;
            try {
                incidentHandling = new CustomerHandleIncidentRequest(
                        customer.getCustomerId(),
                        customerComment.getIncidentDate(),
                        customerComment.getCarNumber(),
                        customerComment.getIncidentSite(),
                        customerComment.getIncidentPhoneNum(),
                        customerComment.getIncidentName()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
            customerService.handleIncident(incidentHandling);
            System.out.println("사고처리가 완료 되었습니다. \n담당자를 배정 후 연락드리겠습니다.");
    }
}
