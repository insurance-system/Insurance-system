package domain.employee.dto;

public class RewardEvaluateResponse {
    private String insuranceClaimId;
    private String customerId;
    private String claimContent;
    private String claimCost;
    private String claimStatus;

    public RewardEvaluateResponse(String insuranceClaimId, String customerId, String claimContent, String claimCost) {
        this.insuranceClaimId = insuranceClaimId;
        this.customerId = customerId;
        this.claimContent = claimContent;
        this.claimCost = claimCost;
    }

    public String getInsuranceClaimId() {
        return insuranceClaimId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getClaimContent() {
        return claimContent;
    }

    public String getClaimCost() {
        return claimCost;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
}
