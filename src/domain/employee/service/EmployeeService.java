package domain.employee.service;

import domain.contract.entity.Contract;
import domain.customer.entity.Customer;
import domain.customer.entity.Payer;
import domain.employee.dto.CustomerConsultResponse;
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

    public ArrayList<CustomerConsultResponse> customerConsult(Employee employee) {
        return this.employeeRepository.customerConsult(employee);
    }

    public void consultExcute(Employee employee, CustomerConsultResponse customerConsultResponse) {
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
        ArrayList<Customer> customers = employeeRepository.selectEmployeeByIds(nearExpiredContractsCustomerIds);
        for (Customer customer : customers) {
            System.out.println("customer = " + customer);
        }
        return null;
    }

    public ArrayList<Payer> getNearPaymentDayPayerList() {
        return null;
    }
}
