package domain.employee.dto;

import domain.customer.enumeration.KindOfJob;
import domain.insurance.entity.enumeration.KindOfInsurance;

public class CustomerConsultResponse {

    private String empCusId;

    public String getEmpCusId() {
        return empCusId;
    }

    public void setEmpCusId(String empCusId) {
        this.empCusId = empCusId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public KindOfInsurance getKindOfInsurance() {
        return kindOfInsurance;
    }

    public void setKindOfInsurance(KindOfInsurance kindOfInsurance) {
        this.kindOfInsurance = kindOfInsurance;
    }

    public KindOfJob getKindOfJob() {
        return kindOfJob;
    }

    public void setKindOfJob(KindOfJob kindOfJob) {
        this.kindOfJob = kindOfJob;
    }

    private String customerId;
    private String name;
    private String phoneNumber;
    private KindOfInsurance kindOfInsurance;
    private KindOfJob kindOfJob;

}
