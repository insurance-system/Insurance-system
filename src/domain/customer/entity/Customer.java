package domain.customer.entity;

import core.insurance.entity.enumeration.KindOfInsurance;

public class Customer{

    private int customerId;
    private String password;
    private int interestInsuranceId;
    private String name;
    private KindOfInsurance kindOfInsurance;
    private String address;
    private String detailAddress;
    private String zipcode;
    private String email;
    private String phoneNumber;
    private String kindOfJob;

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getInterestInsuranceId() {
        return interestInsuranceId;
    }

    public void setInterestInsuranceId(int interestInsuranceId) {
        this.interestInsuranceId = interestInsuranceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KindOfInsurance getKindOfInsurance() {
        return kindOfInsurance;
    }

    public void setKindOfInsurance(KindOfInsurance kindOfInsurance) {
        this.kindOfInsurance = kindOfInsurance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getKindOfJob() {
        return kindOfJob;
    }

    public void setKindOfJob(String kindOfJob) {
        this.kindOfJob = kindOfJob;
    }
}
