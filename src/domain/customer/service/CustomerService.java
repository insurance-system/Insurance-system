package domain.customer.service;

import domain.customer.dto.request.CustomerJoinReq;
import domain.customer.dto.request.CustomerLoginRequest;
import global.dao.client.SubscriptionReq;
import domain.customer.entity.Customer;
import domain.employee.service.SalesEmployeeService;
import domain.customer.repository.CustomerRepository;

import java.util.ArrayList;

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final SalesEmployeeService salesEmployeeService;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
        this.salesEmployeeService = new SalesEmployeeService();
    }

    String join(CustomerJoinReq joinReq){
//        return customerRepository.insert(joinReq.toString());
        return null;
    }

    String subClientToInsurance(String insuranceId, SubscriptionReq subscriptionReq){
        salesEmployeeService.saleInsurance(insuranceId, subscriptionReq);
        return "보험 가입에 성공하셨습니다.";
    }

    public boolean login(CustomerLoginRequest customer) {
        String id = customer.getId();
        String password = customer.getPassword();

        String customerStr = customerRepository.findById(id);

//        Customer findCustomer = Customer.toEntity(customerStr);
//        if(password.equals(findCustomer.getPassword())) return true;
//        else return false;
        return true;
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
