package domain.contract.dto;

import java.time.LocalDate;

public class InsuranceNearExpireAlarm{
    private String customerId;
    private String email;
    private String customerName;
    private String phoneNumber;

    private int InsuranceId;
    private String insuranceName;
    private int fee;
    private LocalDate expiredDate;

    public InsuranceNearExpireAlarm(String customerId,
                                    String email,
                                    String customerName,
                                    String phoneNumber,
                                    int insuranceId,
                                    String insuranceName,
                                    int fee,
                                    LocalDate expiredDate) {
        this.customerId = customerId;
        this.email = email;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        InsuranceId = insuranceId;
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

    public int getInsuranceId() {
        return InsuranceId;
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
