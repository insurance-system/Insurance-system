package domain.insurance.entity;

import domain.insurance.entity.enumeration.CompensationStatus;


public class Compensation {
    private String compensationId;
    private String insuranceId;
    private int maxReward;
    private int minReward;
    private CompensationStatus compensationStatus;
}
