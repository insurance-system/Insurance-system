package domain.employee.service;

import domain.customer.dto.UwRequest;
import domain.customer.dto.UwResponse;

import java.util.ArrayList;

public class UWEmployeeService extends EmployeeService{

    public ArrayList<UwRequest> getUwCustomerList() {
        return this.employeeRepository.getUwCustomerList();
    }

    public UwResponse getUwInformation(String contractId){
        return employeeRepository.getUwInformation(contractId);
    }

    public void activateContract(String contractId) {
        employeeRepository.activateContract(contractId);
    }

    public void failContract(String contractId) {
        employeeRepository.failContract(contractId);
    }
}
