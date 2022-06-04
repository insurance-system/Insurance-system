package domain.contract.dto;

import java.time.LocalDate;

public class InsurancePaymentAlarm {
    private String customerId;
    private int InsuranceId;
    private int fee;
    private String insuranceName;
    private LocalDate paymentDate;
}
