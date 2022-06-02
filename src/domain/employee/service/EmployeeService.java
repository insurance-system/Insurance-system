package domain.employee.service;

import domain.customer.entity.Customer;
import domain.employee.dto.CustomerConsultResponse;
import domain.employee.entity.Employee;
import domain.employee.repository.EmployeeRepository;

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
}
