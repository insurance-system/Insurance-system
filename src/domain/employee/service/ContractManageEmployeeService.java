package domain.employee.service;

import domain.employee.dto.DefaultResponse;
import domain.employee.dto.ExpirationResponse;
import java.util.ArrayList;

//계약관리
public class ContractManageEmployeeService extends EmployeeService{

    public ArrayList<ExpirationResponse> selectContractExpiration() {
        return this.employeeRepository.contractManage();
    }

    public ArrayList<DefaultResponse> selectDefaultCustomer() {
        return this.employeeRepository.selectDefaultCustomer();
    }


    public void cancelInsurance(String insuranceId, String customerId) {
        employeeRepository.expireContract(insuranceId, customerId);
    }
}
