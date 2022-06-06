package domain.customer.dto;


import domain.customer.entity.Grade;
import domain.customer.entity.HealthInformation;
import domain.insurance.entity.enumeration.KindOfInsurance;

public class UwResponse {
    private String contractId;
    private String customerId;
    private HealthInformation customerHealthInformation;

    private String insuranceId;
    private String insuranceName;
    private String fee;
    private KindOfInsurance kindOfInsurance;
    private int maxAge;
    private int minAge;
    private Grade smoke;
    private Grade alcohol;
    private Grade cancer;

    @Override
    public String toString() {
        return "\n\n계약 ID: "+contractId + "\n--고객 정보--\n고객 ID: " +customerId  +"\n고객 건강 정보:[흡연:"+customerHealthInformation.getSmoke()+"  / 음주:"+customerHealthInformation.getAlcohol()+"  / 암(cancer):"+customerHealthInformation.getCancer() +" ]\n"+
                "--보험 정보--\n"+"보험 ID: "+insuranceId+"\n보험 이름:"+insuranceName+"\n보험 종류"+kindOfInsurance.getName()+"\n월 청구비:"+fee+"\n"+
                insuranceName+" 보험의 가입 조건:[흡연:"+customerHealthInformation.getSmoke()+"이상  / 음주:"+customerHealthInformation.getAlcohol()+"이상  / 암(cancer):"+customerHealthInformation.getCancer() +"이상 ]\n";
    }

    public UwResponse() {}

    public UwResponse(String contractId, String customerId, HealthInformation customerHealthInformation, String insuranceId, String insuranceName, String fee, KindOfInsurance kindOfInsurance, int maxAge, int minAge, Grade smoke, Grade alcohol, Grade cancer) {
        this.contractId = contractId;
        this.customerId = customerId;
        this.customerHealthInformation = customerHealthInformation;
        this.insuranceId = insuranceId;
        this.insuranceName = insuranceName;
        this.fee = fee;
        this.kindOfInsurance = kindOfInsurance;
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.smoke = smoke;
        this.alcohol = alcohol;
        this.cancer = cancer;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public HealthInformation getCustomerHealthInformation() {
        return customerHealthInformation;
    }

    public void setCustomerHealthInformation(HealthInformation customerHealthInformation) {
        this.customerHealthInformation = customerHealthInformation;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public KindOfInsurance getKindOfInsurance(KindOfInsurance kindOfInsurance) {
        return this.kindOfInsurance;
    }

    public void setKindOfInsurance(KindOfInsurance kindOfInsurance) {
        this.kindOfInsurance = kindOfInsurance;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public Grade getSmoke() {
        return smoke;
    }

    public void setSmoke(Grade smoke) {
        this.smoke = smoke;
    }

    public Grade getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Grade alcohol) {
        this.alcohol = alcohol;
    }

    public Grade getCancer() {
        return cancer;
    }

    public void setCancer(Grade cancer) {
        this.cancer = cancer;
    }
}
