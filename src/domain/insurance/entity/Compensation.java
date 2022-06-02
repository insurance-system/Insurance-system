package domain.insurance.entity;

import domain.insurance.entity.enumeration.CompensationStatus;


public class Compensation {
    private int compensationId;
    private int insuranceId;
    private int maxReward;
    private int minReward;
    private CompensationStatus compensationStatus;
}
