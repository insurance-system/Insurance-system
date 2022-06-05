package domain.customer.service;

import domain.customer.dto.request.*;
import domain.customer.entity.Customer;
import domain.customer.entity.FindPayment;
import domain.customer.exception.excution.*;
import domain.customer.repository.CustomerRepository;
import domain.employee.service.ContractManageEmployeeService;
import domain.insurance.entity.Insurance;

import java.util.ArrayList;

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ContractManageEmployeeService contractManageEmployeeService;
    public CustomerService() {
        this.customerRepository = new CustomerRepository();
        this.contractManageEmployeeService = new ContractManageEmployeeService();
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
    public ArrayList<FindPayment> findPayment(String id) {
        if(customerRepository.findPayment(id)==null) new NoPaymentHistoryException();
        return customerRepository.findPayment(id);
    }


    public ArrayList<Insurance> findJoinedInsurances(String id) {
        if(customerRepository.findJoinedInsurances(id).isEmpty()) new NoJoinedInsuranceException();
        return customerRepository.findJoinedInsurances(id);

    }

    public void evaluateSatisfaction(String satisfaction, String id) {
        if(customerRepository.checkSatisfaction(id) == null) customerRepository.evaluateSatisfaction(satisfaction, id);
        else new ExistSatisfactionException();
    }

    public void connectSalesEmployee(Customer interestCustomer) {
        customerRepository.joinInterestCustomer(interestCustomer);
        customerRepository.connectSalesEmployee(interestCustomer);
    }

    public String checkSatisfaction(String customerId) {
        if(customerRepository.checkSatisfaction(customerId) == null) new NoEvaluateSatisfactionException();
        return customerRepository.checkSatisfaction(customerId);
    }

    public ArrayList<Insurance> findInterestInsurance(Customer customer) {
        if(customerRepository.findInterestInsurance(customer).isEmpty()) new NoInterestInsuranceException();
        return customerRepository.findInterestInsurance(customer);
    }

    public void joinPayer(String payerId, String account, Customer customer) {
        if(customerRepository.checkPayer(customer) == null) customerRepository.joinPayer(payerId, account, customer);
        else new ExistPayerException();
    }

    public void joinBeneficiary(String beneficiaryId, String account, Customer customer) {
        if(customerRepository.checkBeneficiary(customer) == null) customerRepository.joinBeneficiary(beneficiaryId, account, customer);
        else new ExistBeneficiaryException();
    }

    public String checkJoinNonLifeInsurance(Customer customer) {
        if(customerRepository.checkJoinNonlifeInsurance(customer) == null) new NoJoinNonlifeInsuranceException();
        return customerRepository.checkJoinNonlifeInsurance(customer);
    }

    public void handleIncident(CustomerHandleIncidentRequest incidentHandling) {
        customerRepository.handleIncident(incidentHandling);
    }

    public void claimInsurance(CustomerClaimInsuranceRequest claimInsurance, Customer customer) {
        customerRepository.claimInsurance(claimInsurance);
    }

    public String checkJoinLifeInsurance(Customer customer) {
        if(customerRepository.checkJoinLifeInsurance(customer) == null) new NoJoinLifeInsuranceException();
        return customerRepository.checkJoinLifeInsurance(customer);
    }

    public int checkIdExist(String customerId) {
        if(customerRepository.checkIdExist(customerId)!=0) new ExistCustomerException();
        return customerRepository.checkIdExist(customerId);
    }

    public void addCustomerInformation(InterestCustomerJoinRequest customer, String customerId) {
        customerRepository.addCustomerInformation(customer, customerId);
    }

    public String checkConnection(Customer customer) {
        if(customerRepository.checkConnection(customer) == null) new NoConnectionWithEmployeeException();
            return customerRepository.checkConnection(customer);
    }

    public String getContractId() {
        return customerRepository.findLastContractId();
    }

    public ArrayList<Insurance> getJoinedInsurances() {
        return null;
    }

    public void cancelInsurance(String insuranceId, String customerId) {
        contractManageEmployeeService.cancelInsurance(insuranceId, customerId);
    }
}
