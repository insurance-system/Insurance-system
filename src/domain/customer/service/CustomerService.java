package domain.customer.service;

import domain.customer.dto.request.CustomerJoinReq;
import domain.customer.dto.request.CustomerLoginRequest;
import global.dao.client.SubscriptionReq;
import domain.customer.entity.Customer;
import domain.employee.service.SalesEmployeeService;
import domain.customer.repository.CustomerRepository;
import global.util.Choice;

import java.util.ArrayList;

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final SalesEmployeeService salesEmployeeService;
    private final Choice choice;

    public CustomerService(Choice choice) {
        this.customerRepository = new CustomerRepository();
        this.salesEmployeeService = new SalesEmployeeService();
        this.choice = choice;
    }

    String join(CustomerJoinReq joinReq){
//        return customerRepository.insert(joinReq.toString());
        return null;
    }

    String subClientToInsurance(String insuranceId, SubscriptionReq subscriptionReq){
        salesEmployeeService.saleInsurance(insuranceId, subscriptionReq);
        return "보험 가입에 성공하셨습니다.";
    }

    public Customer login(CustomerLoginRequest customerLoginRequest) {
//        String id = customer.getId();
//        String password = customer.getPassword();
        Customer customerLogin = customerRepository.login(customerLoginRequest.getId(), customerLoginRequest.getPassword());
//        String customerStr = customerRepository.findById(id);

//        Customer findCustomer = Customer.toEntity(customerStr);
//        if(password.equals(findCustomer.getPassword())) return true;
//        else return false;
        return customerLogin;
    }

    public Customer connect(ArrayList<String> strings) {
        customerRepository.insertInterest(strings);
        return null;
    }

//    String getInsuranceInfo(String insuranceId){
//
//    }
//
//    List<InsuranceResp> getInsurancesInfo(String clientId){
//
//    }
//
//    String getContract(String clientId, String contractId){
//
//    }
//    String getContracts(String clientId){
//
//    }
//
//    String pay(String contractId){
//
//    }
}
