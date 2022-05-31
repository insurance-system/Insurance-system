package core.insurance.entity;

import core.insurance.entity.enumeration.InsuranceStatus;
import core.insurance.entity.enumeration.KindOfInsurance;

public class Insurance {
    private int insuranceId;
    private int insuranceConditionId;
    private KindOfInsurance kindOfInsurance;
    private String insuranceName;
    private int fee;
    private InsuranceStatus insuranceStatus;
}