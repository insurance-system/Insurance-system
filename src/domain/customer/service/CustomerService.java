package domain.customer.service;

import domain.customer.dto.request.CustomerJoinRequest;
import domain.customer.dto.request.CustomerLoginRequest;
import domain.customer.entity.Customer;
import domain.employee.service.SalesEmployeeService;
import domain.customer.repository.CustomerRepository;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    public boolean join(CustomerJoinRequest joinReq){
        //TODO 아이디, 패스워드, 주소 등 유효성 검사
        Customer customer = CustomerJoinRequest.toEntity(joinReq);
        customerRepository.insert(customer);
        return true;
    }

//    String subClientToInsurance(String insuranceId, SubscriptionReq subscriptionReq){
//        salesEmployeeService.saleInsurance(insuranceId, subscriptionReq);
//        return "보험 가입에 성공하셨습니다.";
//    }

    public Customer login(CustomerLoginRequest customerLoginRequest) {
        return customerRepository.login(customerLoginRequest.getId(), customerLoginRequest.getPassword());
    }

//    public Customer connect(ArrayList<String> strings) {
//        customerRepository.insertInterest(strings);
//        return null;
//    }
}
