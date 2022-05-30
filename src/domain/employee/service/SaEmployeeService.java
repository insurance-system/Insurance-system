package domain.employee.service;


import domain.insurance.entity.Insurance;
import global.dao.client.ClientHealthInformation;

// SA : Subscription Audit
public class SaEmployeeService {

    public boolean AuditSubscription(ClientHealthInformation clientHealthInformation, Insurance insurance) {
        /*
        * 고객의 건강 정보와 보험 정보를 비교하여 가입할 수 있다면 true, 아니아면 false
        *
        * */
        return true;
    }
}
