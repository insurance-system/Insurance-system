package domain.contract.dto;

import domain.insurance.entity.InsuranceCondition;
import domain.insurance.entity.enumeration.KindOfInsurance;

public class NewInsurance {

    private String insuranceName;
    private KindOfInsurance kindOfInsurance;
    private int fee;
    private InsuranceCondition insuranceCondition;

    public NewInsurance(String insuranceName, int kindOfInsurance, int fee, InsuranceCondition insuranceCondition) {
        this.insuranceName = insuranceName;
        this.kindOfInsurance = KindOfInsurance.getKindOfInsuranceBy(kindOfInsurance);
        this.fee = fee;
        this.insuranceCondition = insuranceCondition;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public KindOfInsurance getKindOfInsurance() {
        return kindOfInsurance;
    }

    public void setKindOfInsurance(KindOfInsurance kindOfInsurance) {
        this.kindOfInsurance = kindOfInsurance;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public InsuranceCondition getInsuranceCondition() {
        return insuranceCondition;
    }

    public void setInsuranceCondition(InsuranceCondition insuranceCondition) {
        this.insuranceCondition = insuranceCondition;
    }
}
