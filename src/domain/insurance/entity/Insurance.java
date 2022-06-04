package domain.insurance.entity;

import domain.insurance.entity.enumeration.KindOfInsurance;

public class Insurance {

    private int insuranceId;
    private String insuranceConditionId;
    private KindOfInsurance kindOfInsurance;
    private String insuranceName;
    private int fee;
//    private InsuranceStatus insuranceStatus;

    public Insurance(String insuranceName, int fee){
        this.insuranceName = insuranceName;
        this.fee = fee;
    }

    public Insurance() {
    }


    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
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

    public void setKindOfInsurance(KindOfInsurance kindOfInsurance) {
        this.kindOfInsurance = kindOfInsurance;
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

//    public InsuranceStatus getInsuranceStatus() {
//        return insuranceStatus;
//    }
//
//    public void setInsuranceStatus(InsuranceStatus insuranceStatus) {
//        this.insuranceStatus = insuranceStatus;
//    }
}

