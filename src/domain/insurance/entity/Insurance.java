package domain.insurance.entity;

import domain.customer.enumeration.KindOfJob;
import domain.insurance.entity.enumeration.InsuranceStatus;
import domain.insurance.entity.enumeration.KindOfInsurance;

import static domain.insurance.entity.enumeration.InsuranceStatus.setInsuranceStatusBy;
import static domain.insurance.entity.enumeration.KindOfInsurance.getKindOfInsuranceNByName;

public class Insurance {

    public Insurance(
            String insuranceId,
            String insuranceConditionId,
            KindOfInsurance kindOfInsurance,
            String insuranceName,
            int fee,
            InsuranceStatus insuranceStatus
    ){
        this.insuranceId = insuranceId;
        this.insuranceConditionId = insuranceConditionId;
        this.kindOfInsurance = kindOfInsurance;
        this.insuranceName = insuranceName;
        this.fee = fee;
        this.insuranceStatus = insuranceStatus;
    }

    private String insuranceId;
    private String insuranceConditionId;
    private KindOfInsurance kindOfInsurance;
    private String insuranceName;
    private int fee;
    private InsuranceStatus insuranceStatus;

    public Insurance() {

    }
//    private InsuranceStatus insuranceStatus;

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceConditionId() {
        return insuranceConditionId;
    }

    public void setInsuranceConditionId(String insuranceConditionId) {
        this.insuranceConditionId = insuranceConditionId;
    }

    public KindOfInsurance getKindOfInsurance() {
        return kindOfInsurance;
    }

    public void setKindOfInsurance(String kindOfInsurance) {
        this.kindOfInsurance = getKindOfInsuranceNByName(kindOfInsurance);
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }


    public InsuranceStatus getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(String insuranceStatus) {
        this.insuranceStatus = setInsuranceStatusBy(insuranceStatus);
    }
}

