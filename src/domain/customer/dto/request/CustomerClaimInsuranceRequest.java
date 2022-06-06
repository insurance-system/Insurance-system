package domain.customer.dto.request;


public class CustomerClaimInsuranceRequest {

    private String customerId;
    private String claimContent;
    private int claimCost;
    private String contractId;

    public CustomerClaimInsuranceRequest(
                    String customerId,
                    String claimContent,
                    int claimCost,
                    String contractId) {
        this.customerId = customerId;
        this.claimContent = claimContent;
        this.claimCost = claimCost;
        this.contractId = contractId;
    }

    public String getContractId() {
        return contractId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getClaimContent() {
        return claimContent;
    }

    public void setClaimContent(String claimContent) {
        this.claimContent = claimContent;
    }

    public int getClaimCost() {
        return claimCost;
    }

    public void setClaimCost(int claimCost) {
        this.claimCost = claimCost;
    }
}
