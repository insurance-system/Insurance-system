package domain.customer.dto.request;

import java.sql.Date;

public class CustomerClaimInsuranceRequest {

    private String customerId;
    private String claimContent;
    private int claimCost;

    public CustomerClaimInsuranceRequest(
                    String customerId,
                    String claimContent,
                    int claimCost) {
        this.customerId = customerId;
        this.claimContent = claimContent;
        this.claimCost = claimCost;
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
