package domain.employee.service;

import domain.contract.entity.Contract;
import domain.employee.dto.EmpCustomer;
import domain.employee.entity.Employee;

import java.util.ArrayList;

public class SalesEmployeeService extends EmployeeService{

    public ArrayList<EmpCustomer> customerConsult(Employee employee) {
        return this.employeeRepository.customerConsult(employee);
    }

    public void executeConsult(Employee employee, EmpCustomer customerConsultResponse) {
        this.employeeRepository.executeConsult(employee, customerConsultResponse);
    }

    public void makeInsuranceContract(Contract contract) {
        this.employeeRepository.makeInsuranceContract(contract.toEntity(contract));
    }
}
