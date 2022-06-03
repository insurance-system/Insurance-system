package domain.employee.service;

import domain.contract.entity.Contract;
import domain.customer.entity.Payer;
import domain.employee.dto.Customer;
import domain.employee.dto.DefaultResponse;
import domain.employee.dto.ExpirationResponse;
import domain.employee.entity.Employee;
import domain.employee.repository.EmployeeRepository;
import global.dao.Lecture;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();

    }

    public Employee login(String employeeId, String password) {
        return this.employeeRepository.login(employeeId,password);
    }

    public ArrayList<Customer> customerConsult(Employee employee) {
        return this.employeeRepository.customerConsult(employee);
    }

    public void consultExcute(Employee employee, Customer customerConsultResponse) {
        this.employeeRepository.consultExcute(employee, customerConsultResponse);
    }
    public void findLectureRegistrationList() {

    }

    public boolean uploadEducationLecture(Lecture lecturer) {
        return employeeRepository.insertLecture(lecturer);
    }

    public ArrayList<Lecture> findLectureList(){
        return employeeRepository.selectLectureList();
    }


    public ArrayList<Payer> getNearExpiredPayerList() {
        ArrayList<Contract> contracts = employeeRepository.selectContractList();
        ArrayList<String> nearExpiredContractsCustomerIds = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Contract contract : contracts){
            Period between = Period.between(contract.getExpiredDate(), now);
            if(between.getDays() <= 5) nearExpiredContractsCustomerIds.add(contract.getCustomerId());
        }
        ArrayList<domain.customer.entity.Customer> customers = employeeRepository.selectEmployeeByIds(nearExpiredContractsCustomerIds);
        for (domain.customer.entity.Customer customer : customers) {
            System.out.println("customer = " + customer);
        }
        return null;
        //TODO InsuranceNearExpireAlarm 객체로 바꿔서 이메일 보내기
    }

    public ArrayList<Payer> getNearPaymentDayPayerList() {
        // TODO InsurancePaymentAlarm 객체로 바꿔서 이메일 보내기
        return null;
    }

    public ArrayList<ExpirationResponse> selectContractExpiration() {
        return this.employeeRepository.contractManage();
    }

    public ArrayList<DefaultResponse> selectDefaultCustomer() {
        return this.employeeRepository.selectDefaultCustomer();
    }
}
