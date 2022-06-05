package domain.employee.service;

import domain.employee.entity.Employee;
import domain.employee.repository.EmployeeRepository;


public class EmployeeService {

    protected EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();

    }

    public Employee login(String employeeId, String password) {
        return this.employeeRepository.login(employeeId,password);
    }

}