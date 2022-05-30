package core.insurance.service;

import core.insurance.entity.Insurance;
import core.insurance.repository.InsuranceRepository;

public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    public InsuranceService() {
        this.insuranceRepository = new InsuranceRepository();
    }

    public Insurance getInsuranceById(String insuranceId) {
        String insuranceStr = insuranceRepository.findById(insuranceId);
        return Insurance.makeObject(insuranceStr);
    }
}
