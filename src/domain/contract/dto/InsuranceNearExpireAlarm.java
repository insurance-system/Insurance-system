package domain.contract.dto;

import java.time.LocalDate;

public class InsuranceNearExpireAlarm{
    private String customerId;
    private String email;
    private String customerName;
    private String phoneNumber;

    private String insuranceId;
    private String insuranceName;
    private int fee;
    private LocalDate expiredDate;

    public InsuranceNearExpireAlarm(String customerId,
                                    String email,
                                    String customerName,
                                    String phoneNumber,
                                    String insuranceId,
                                    String insuranceName,
                                    int fee,
                                    LocalDate expiredDate) {
        this.customerId = customerId;
        this.email = email;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.insuranceId = insuranceId;
        this.insuranceName = insuranceName;
        this.fee = fee;
        this.expiredDate = expiredDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public int getFee() {
        return fee;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }
}
