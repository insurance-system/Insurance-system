package domain.employee.service;

import domain.employee.dto.EmpCustomer;
import domain.employee.entity.Employee;
import domain.employee.repository.EmployeeRepository;

import java.util.ArrayList;

public class SalesEmployeeService extends EmployeeService{

    public ArrayList<EmpCustomer> customerConsult(Employee employee) {
        return this.employeeRepository.customerConsult(employee);
    }

    public void consultExecute(Employee employee, EmpCustomer customerConsultResponse) {
        this.employeeRepository.consultExecute(employee, customerConsultResponse);
    }
}
