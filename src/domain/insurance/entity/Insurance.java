package domain.insurance.entity;

import domain.insurance.entity.enumeration.InsuranceStatus;
import domain.insurance.entity.enumeration.KindOfInsurance;

public class Insurance {
    private String insuranceId;
    private String insuranceConditionId;
    private KindOfInsurance kindOfInsurance;
    private String insuranceName;
    private int fee;
    private InsuranceStatus insuranceStatus;
}