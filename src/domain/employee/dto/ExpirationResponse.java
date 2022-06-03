package domain.employee.dto;

import domain.contract.entity.Contract;
import domain.customer.entity.Customer;
import domain.customer.enumeration.KindOfJob;
import domain.insurance.entity.enumeration.KindOfInsurance;

public class ExpirationResponse {

    private String customerID;
    private String name;
    private String phoneNumber;
    private String email;
    private KindOfJob kindOfJob;
    private KindOfInsurance kindOfInsurance;
    private String insuranceName;
    private String insuranceStatus;
    private String contractStatus;

    public ExpirationResponse(String customerID, String name, String phoneNumber, String email, KindOfJob kindOfJob, KindOfInsurance kindOfInsurance, String insuranceName, String insuranceStatus, String contractStatus) {
        this.customerID = customerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.kindOfJob = kindOfJob;
        this.kindOfInsurance = kindOfInsurance;
        this.insuranceName = insuranceName;
        this.insuranceStatus = insuranceStatus;
        this.contractStatus = contractStatus;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public KindOfJob getKindOfJob() {
        return kindOfJob;
    }

    public void setKindOfJob(KindOfJob kindOfJob) {
        this.kindOfJob = kindOfJob;
    }

    public KindOfInsurance getKindOfInsurance() {
        return kindOfInsurance;
    }

    public void setKindOfInsurance(KindOfInsurance kindOfInsurance) {
        this.kindOfInsurance = kindOfInsurance;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(String insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }
}
