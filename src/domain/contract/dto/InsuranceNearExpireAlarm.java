package domain.contract.dto;

import java.time.LocalDate;

public class InsuranceNearExpireAlarm {
    private String customerId;
    private int InsuranceId;
    private String insuranceName;
    private LocalDate expiredDate;
}
