package domain.employee.service;

import domain.insurance.entity.Insurance;
import domain.insurance.service.InsuranceService;
import global.dao.client.SubscriptionReq;

public class SalesEmployeeService {

    private final SaEmployeeService saEmployeeService;
    private final InsuranceService insuranceService;
    private final ContractService contractService;

    public SalesEmployeeService() {
        this.saEmployeeService = new SaEmployeeService();
        this.contractService = new ContractService();
        this.insuranceService = new InsuranceService();
    }

//    List<InsuranceResp> recommandInsurance(String clientId);

    public boolean saleInsurance(String insuranceId, SubscriptionReq subscriptionReq) {
//        Insurance insurance = insuranceService.getInsuranceById(insuranceId);
//        if(saEmployeeService.AuditSubscription(subscriptionReq.getClientHealthInformation(), insurance))
//            return makeContract(subscriptionReq.getClientId(), insuranceId);
//        else return false;
        return true;
    }

    private boolean makeContract(String clientId, String insuranceId){
        //뭐 또 필요한 로직....
        this.contractService.makeContract(clientId, insuranceId);
        return true;
    }
}
