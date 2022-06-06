package domain.employee.service;

import domain.customer.dto.UwRequest;
import domain.customer.dto.UwResponse;

import java.util.ArrayList;

public class UWEmployeeService extends EmployeeService{

    // TODO 인수심사 대기 명단 고객 테이블에서 select ALL 해오기
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
