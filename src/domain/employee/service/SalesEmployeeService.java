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
        this.employeeRepository.consultExecute(employee, customerConsultResponse);
    }

    public void doInsuranceContract(Contract contract) {
        this.employeeRepository.doInsuranceContract(contract.toEntity(contract));
    }
}
