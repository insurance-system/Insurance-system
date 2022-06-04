package domain.employee.service;

import domain.contract.dto.NewInsurance;

public class InsuranceDevelopmentEmployeeService extends EmployeeService{

    public boolean developInsurance(NewInsurance newInsurance) {
        employeeRepository.insertNewInsurance(newInsurance);
        return true;
    }
}
