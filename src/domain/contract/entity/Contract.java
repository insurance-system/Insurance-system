package domain.contract.entity;

import java.time.LocalDate;

public class Contract {
    private int contractId;
    private String customerId;
    private int chargeOfEmployeeId;
    private int insuranceId;
    private LocalDate expiredDate;
    private LocalDate paymentDate;
    private String contractStatus;

    public int getContractId() {
        return contractId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getChargeOfEmployeeId() {
        return chargeOfEmployeeId;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setChargeOfEmployeeId(int chargeOfEmployeeId) {
        this.chargeOfEmployeeId = chargeOfEmployeeId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", customerId='" + customerId + '\'' +
                ", chargeOfEmployeeId=" + chargeOfEmployeeId +
                ", insuranceId=" + insuranceId +
                ", expiredDate=" + expiredDate +
                ", paymentDate=" + paymentDate +
                ", contractStatus='" + contractStatus + '\'' +
                '}';
    }
}
