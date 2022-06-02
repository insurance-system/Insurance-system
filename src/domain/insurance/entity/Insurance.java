package domain.insurance.entity;

import domain.insurance.entity.enumeration.InsuranceStatus;
import domain.insurance.entity.enumeration.KindOfInsurance;

public class Insurance {
    private int insuranceId;
    private int insuranceConditionId;
    private KindOfInsurance kindOfInsurance;
    private String insuranceName;
    private int fee;
    private InsuranceStatus insuranceStatus;
}