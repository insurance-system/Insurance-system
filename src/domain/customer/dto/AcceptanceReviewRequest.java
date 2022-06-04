package domain.customer.dto;

public class AcceptanceReviewRequest {
    private String customerId;
    private int requestInsuranceId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getRequestInsuranceId() {
        return requestInsuranceId;
    }

    public void setRequestInsuranceId(int requestInsuranceId) {
        this.requestInsuranceId = requestInsuranceId;
    }
}
