package domain.customer.dto.request;

import java.sql.Date;

public class CustomerHandleIncidentRequest {

    private String customerId;
    private Date incidentDate;
    private String carNumber;
    private String incidentSite;
    private String incidentPhoneNum;
    private String incidentName;

    public CustomerHandleIncidentRequest(
                    String customerId,
                    Date incidentDate,
                    String carNumber,
                    String incidentSite,
                    String incidentPhoneNum,
                    String incidentName) {
        this.customerId = customerId;
        this.incidentDate = incidentDate;
        this.carNumber = carNumber;
        this.incidentSite = incidentSite;
        this.incidentPhoneNum = incidentPhoneNum;
        this.incidentName = incidentName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public String getIncidentPhoneNum() {
        return incidentPhoneNum;
    }

    public String getIncidentName() {
        return incidentName;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getIncidentSite() {
        return incidentSite;
    }

    public void setIncidentSite(String incidentSite) {
        this.incidentSite = incidentSite;
    }
}
