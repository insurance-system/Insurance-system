package domain.contract.entity;

import java.time.LocalDate;

public class Contract {
    private String contractId;
    private String customerId;
    private String chargeOfEmployeeId;
    private String insuranceId;
    private LocalDate expiredDate;
    private LocalDate paymentDate;
    private String contractStatus;

    public Contract(
            String contractId,
            String customerId,
            String chargeOfEmployeeId,
            String insuranceId,
            LocalDate expiredDate,
            LocalDate paymentDate,
            String contractStatus) {
        this.contractId = contractId;
        this.customerId = customerId;
        this.chargeOfEmployeeId = chargeOfEmployeeId;
        this.insuranceId = insuranceId;
        this.expiredDate = expiredDate;
        this.paymentDate = paymentDate;
        this.contractStatus = contractStatus;
    }

    public Contract() {
    }

    public String getContractId() {
        return contractId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getChargeOfEmployeeId() {
        return chargeOfEmployeeId;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setChargeOfEmployeeId(String chargeOfEmployeeId) {
        this.chargeOfEmployeeId = chargeOfEmployeeId;
    }

    public void setInsuranceId(String insuranceId) {
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
        return "[" +
                "계약 ID :" + contractId +
                ", 고객 ID :" + customerId +
                ", 계약 완료 직원 ID :" + chargeOfEmployeeId +
                ", 보험 ID :" + insuranceId +
                ", 계약 만료일 :" + expiredDate +
                ", 보험료 납부일 :" + paymentDate +
                ", 계약 상태 :" + contractStatus +
                ']';
    }

    public Contract toEntity(Contract contract){
        contract.setContractStatus(null);
        contract.setExpiredDate(LocalDate.now().plusYears(2));
        contract.setPaymentDate(LocalDate.now());
        contract.setChargeOfEmployeeId("E0100");
        return contract;
    }
}
