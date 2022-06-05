package domain.customer.dto;

public class UwRequest {
    private String id;
    private String customerId;
    private String requestInsuranceId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRequestInsuranceId() {
        return requestInsuranceId;
    }

    public void setRequestInsuranceId(String requestInsuranceId) {
        this.requestInsuranceId = requestInsuranceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
