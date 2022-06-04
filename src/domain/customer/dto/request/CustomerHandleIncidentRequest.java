package domain.customer.dto.request;

import domain.customer.entity.Customer;
import domain.customer.enumeration.KindOfJob;
import domain.insurance.entity.enumeration.KindOfInsurance;

import java.sql.Date;

import static domain.customer.enumeration.KindOfJob.getKindOfJobBy;
import static domain.insurance.entity.enumeration.KindOfInsurance.getKindOfInsuranceBy;

public class CustomerHandleIncidentRequest {

    private String customerId;
    private Date incidentDate;
    private String carNumber;
    private String incidentSite;

    public CustomerHandleIncidentRequest(
                    String customerId,
                    Date incidentDate,
                    String carNumber,
                    String incidentSite) {
        this.customerId = customerId;
        this.incidentDate = incidentDate;
        this.carNumber = carNumber;
        this.incidentSite = incidentSite;
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
