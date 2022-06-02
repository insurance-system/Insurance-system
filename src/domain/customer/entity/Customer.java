package domain.customer.entity;

import domain.insurance.entity.enumeration.KindOfInsurance;
import domain.customer.enumeration.KindOfJob;

import static domain.insurance.entity.enumeration.KindOfInsurance.getKindOfInsuranceBy;
import static domain.customer.enumeration.KindOfJob.getKindOfJobBy;

public class Customer{

    private String customerId;
    private String password;
    private String name;
    private String email;
    private String address;
    private String detailAddress;
    private String zipcode;
    private String phoneNumber;
    private KindOfInsurance kindOfInsurance;
    private KindOfJob kindOfJob;

    public Customer() {}

    public Customer(String customerId,
                    String password,
                    String name,
                    String address,
                    String detailAddress,
                    String zipcode,
                    String email,
                    String phoneNumber,
                    int kindOfJobId,
                    int kindOfInsuranceId){
        this.customerId = customerId;
        this.password = password;
        this.name = name;
        this.kindOfInsurance = getKindOfInsuranceBy(kindOfInsuranceId);

        this.address = address;
        this.detailAddress = detailAddress;
        this.zipcode = zipcode;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.kindOfJob = getKindOfJobBy(kindOfJobId);
    }

    public Customer(String customerId,
                    String password,
                    String name,
                    String address,
                    String detailAddress,
                    String zipcode,
                    String email,
                    String phoneNumber,
                    KindOfJob kindOfJobId,
                    KindOfInsurance kindOfInsuranceId){
        this.customerId = customerId;
        this.password = password;
        this.name = name;
        this.kindOfInsurance = kindOfInsuranceId;

        this.address = address;
        this.detailAddress = detailAddress;
        this.zipcode = zipcode;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.kindOfJob = kindOfJobId;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public KindOfJob getKindOfJob() {
        return kindOfJob;
    }

    public void setKindOfJob(KindOfJob kindOfJob) {
        this.kindOfJob = kindOfJob;
    }
}
