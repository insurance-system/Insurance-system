package domain.employee.service;


public class ContractService {

    private final ContractRepository contractRepository;

    public ContractService() {
        this.contractRepository = new ContractRepository();
    }

    public void makeContract(String clientId, String insuranceId) {
        //일단 계약에는 clientId와 insuranceId만 들어간다고 가정
        String insertData = clientId + " " +insuranceId;
        contractRepository.insert(insertData);
    }
}
