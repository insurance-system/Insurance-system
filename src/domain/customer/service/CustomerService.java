package domain.customer.service;

import domain.customer.dto.request.CustomerJoinRequest;
import domain.customer.dto.request.CustomerLoginRequest;
import domain.customer.entity.Customer;
import domain.customer.repository.CustomerRepository;
import domain.insurance.entity.Insurance;

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

    public Customer login(CustomerLoginRequest customerLoginRequest) {
        return customerRepository.login(customerLoginRequest.getId(), customerLoginRequest.getPassword());
    }
    //Customer, Payer, Contract, Insurance, PayHistory
    public void findPayment() {

    }


    public Insurance findJoinedInsurances(String id) {
        return customerRepository.findJoinedInsurances(id);

    }
}
