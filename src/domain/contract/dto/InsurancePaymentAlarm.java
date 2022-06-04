package domain.contract.dto;

import java.time.LocalDate;

public class InsurancePaymentAlarm {
    private String customerId;
    private String insuranceId;
    private int fee;
    private String insuranceName;
    private LocalDate paymentDate;
}
