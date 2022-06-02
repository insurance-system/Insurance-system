package domain.employee.service;

import domain.employee.entity.Employee;
import domain.employee.repository.EmployeeRepository;

import java.util.ArrayList;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();

    }

    public Employee login(String employeeId, String password) {
        this.employeeRepository.login(employeeId,password);

        return null;
    }

}
