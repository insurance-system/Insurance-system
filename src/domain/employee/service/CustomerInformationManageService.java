package domain.employee.service;

import domain.employee.dto.CustomerAnalysisInformation;

import java.util.ArrayList;

public class CustomerInformationManageService extends EmployeeService{


    public ArrayList<CustomerAnalysisInformation> provideCustomerInformation() {
        return this.employeeRepository.provideCustomerInformation();
    }
}
