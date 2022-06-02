package domain.customer.controller;

import domain.customer.dto.request.CustomerJoinRequest;
import domain.customer.dto.request.CustomerLoginRequest;
import domain.customer.entity.Customer;
import domain.customer.service.CustomerService;
import global.util.Choice;

public class CustomerController {

    private final CustomerService customerService;
    private final Choice choice;

    public CustomerController(Choice choice) {
        this.customerService = new CustomerService();
        this.choice = choice;
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
                connect();
                break;
            default:
                System.out.println("메뉴 1,2,3 중 하나만 입력해주세요.");
                break;
        }
    }

    public void login() {
        CustomerLoginRequest customerLoginRequest
                = new CustomerLoginRequest(choice.getId(), choice.getPassword());
        Customer customer = customerService.login(customerLoginRequest);
        if(customer != null){
            System.out.println("로그인 성공");
            enter(customer);
        }
        else System.out.println("아이디 혹은 비번이 틀렸음");
    }

    public void enter(Customer customer){
        System.out.println(customer.getName() + "님 안녕하세요!");
        switch (choice.afterLogin()){
            case 1:
                connectSalesEmployee();
                break;
            case 2:
                findJoinedInsurances();
                break;
            case 3: //성식 3. 보험급 납부내역
                findPaymentHistory();
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
    }

    private void registerInsurance() {
    }

    private void writeQnA() {
    }
    //보험금 납부 내역
    private void findPaymentHistory() {
        customerService.findPayment();
    }

    private void findJoinedInsurances() {
    }

    private void connectSalesEmployee() {

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

//     public
}
