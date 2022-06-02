package core.insurance.entity;

import core.insurance.entity.enumeration.CompensationStatus;


public class Compensation {
    private int compensationId;
    private int insuranceId;
    private int maxReward;
    private int minReward;
    private CompensationStatus compensationStatus;
}