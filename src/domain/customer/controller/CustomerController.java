package domain.customer.controller;

import domain.customer.dto.request.CustomerJoinRequest;
import domain.customer.dto.request.CustomerLoginRequest;
import domain.customer.entity.Customer;
import domain.customer.entity.FindPayment;
import domain.customer.service.CustomerService;
import domain.insurance.entity.Insurance;
import global.util.Choice;
import global.util.CustomerComment;

public class CustomerController {

    private final CustomerService customerService;
    private final Choice choice;
    private final CustomerComment customerComment;

    public CustomerController(Choice choice) {
        this.customerService = new CustomerService();
        this.choice = choice;
        this.customerComment = new CustomerComment();
    }

    public void initial() {
        switch(choice.customerInitial()){
            case 1:
                login();
                break;
            case 2:
                join();
                break;
            case 3:
                connectSalesEmployee();
                break;
            default:
                System.out.println("메뉴 1,2,3 중 하나만 입력해주세요.");
                break;
        }
    }

    public void login() {
        String id = choice.getId();
        String pw = choice.getPassword();
        CustomerLoginRequest customerLoginRequest
                = new CustomerLoginRequest(id, pw);
            Customer customer = customerService.login(customerLoginRequest);
            if(customer != null){
                System.out.println("로그인 성공");
                if(customer.getAddress() == null) {
                    enterInterest(customer);
                } else
                    enter(customer);
            }
            else{
                System.out.println("아이디 혹은 비번이 틀렸음");
                login();
            }

    }

    private void enterInterest(Customer customer) {
        System.out.println(customer.getName() + "님 안녕하세요!");
        switch (choice.afterLoginInterest()){
            case 1: //1. 상담사 연결하기
                connectSalesEmployee();
                break;
            case 2: //2. 상담사 평가하기
                evaluateSatisfaction(customer);
                choice.employeeInitial();
                break;
            default:
                break;
        }
    }

    private void evaluateSatisfaction(Customer customer) {
        String satisfaction = choice.getSatisfaction();
        customerService.evaluateSatisfaction(satisfaction,customer.getCustomerId());
        System.out.println(customer.getName()+"님 만족도 평가에 참여해주셔서 감사합니다");
    }

    public void enter(Customer customer){
        System.out.println(customer.getName() + "님 안녕하세요!");
        switch (choice.afterLogin()){
            case 1: //1. 상담사 연결하기
                connectSalesEmployee();
                break;
            case 2: //2. 가입된 보험 조회하기
                Insurance insurance = findJoinedInsurances(customer.getCustomerId());
                customerComment.insuranceInformation(insurance);
                afterfindJoinedInsurances(customer);
                break;
            case 3: //성식 3. 보험급 납부내역
                FindPayment findPayment = findPaymentHistory(customer.getCustomerId());
                customerComment.findPaymentHistory(findPayment);
                enter(customer);
                break;
            case 4:
                writeQnA();
                break;
            case 5:
                break;
            case 6:
                registerInsurance();
                break;
            default:
                break;
        }
        enter(customer);
    }


    private void afterfindJoinedInsurances(Customer customer) {
        switch(choice.afterfindJoinedInsurances()) {
            case 1:
                //보험해지하고싶어요~
                break;
            case 2:
                enter(customer);
                break;
        }
    }

    private void registerInsurance() {
    }

    private void writeQnA() {
    }

    //보험금 납부 내역
    private FindPayment findPaymentHistory(String id) {
        return customerService.findPayment(id);
    }

    private Insurance findJoinedInsurances(String id) {
        return customerService.findJoinedInsurances(id);
    }

    private void connectSalesEmployee() {
        //상담사연결받아오기
        /*
        id, name, kindOfInsurance, phonenumber, job
         */

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

        customerService.connectSalesEmployee(interestCustomer);

        System.out.println(interestCustomer.getName()+"님 상담 요청이 완료되었습니다. 빠른 시일 내에 연락드리겠습니다.");
    }

    public void join() {
        String customerId = choice.getId();
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

        System.out.println("customer = " + customer);

        customerService.join(customer);
        System.out.println("회원가입이 완료되었습니다. 로그인을 해주세요!");
        login();
    }

    public void connect() {
        choice.afterLogin();
    }

}
