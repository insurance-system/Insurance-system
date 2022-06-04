package domain.insurance.dto;

import domain.customer.entity.Grade;
import domain.insurance.entity.enumeration.KindOfInsurance;

public class AcceptanceReviewInsurance {
    private String insuranceId;
    private String insuranceName;
    private int fee;
    private int maxAge;
    private int minAge;
    private Grade smoke;
    private Grade alcohol;
    private Grade cancer;
    private KindOfInsurance kindOfInsurance;

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

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
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

    public KindOfInsurance getKindOfInsurance() {
        return kindOfInsurance;
    }

    public void setKindOfInsurance(KindOfInsurance kindOfInsurance) {
        this.kindOfInsurance = kindOfInsurance;
    }

    public Grade getCancer() {
        return cancer;
    }

    public void setCancer(Grade cancer) {
        this.cancer = cancer;
    }
}
