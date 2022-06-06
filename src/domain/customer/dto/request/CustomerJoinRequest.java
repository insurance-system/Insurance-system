package domain.customer.dto.request;

import domain.insurance.entity.enumeration.KindOfInsurance;
import domain.customer.entity.Customer;
import domain.customer.enumeration.KindOfJob;

import static domain.insurance.entity.enumeration.KindOfInsurance.getKindOfInsuranceBy;
import static domain.customer.enumeration.KindOfJob.getKindOfJobBy;

public class CustomerJoinRequest {

    private String customerId;
    private String password;
    private String interestInsuranceId;
    private String name;
    private KindOfInsurance kindOfInsurance;
    private String address;
    private String detailAddress;
    private String zipcode;
    private String email;
    private String phoneNumber;
    private KindOfJob kindOfJob;
    private String ssn;

    public CustomerJoinRequest(
                    String customerId,
                    String password,
                    String name,
                    String address,
                    String detailAddress,
                    String zipcode,
                    String email,
                    String phoneNumber,
                    int kindOfJobId,
                    int kindOfInsuranceId,
                    String ssn) {
        this.customerId = customerId;
        this.password = password;
        this.name = name;
        this.address = address;
        this.detailAddress = detailAddress;
        this.zipcode = zipcode;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.kindOfJob = getKindOfJobBy(kindOfJobId);
        this.kindOfInsurance = getKindOfInsuranceBy(kindOfInsuranceId);
        this.ssn = ssn;
    }

    public static Customer toEntity(CustomerJoinRequest joinReq) {
        return new Customer(
                joinReq.getCustomerId(),
                joinReq.getPassword(),
                joinReq.getName(),
                joinReq.getAddress(),
                joinReq.getDetailAddress(),
                joinReq.getZipcode(),
                joinReq.getEmail(),
                joinReq.getPhoneNumber(),
                joinReq.getKindOfJob(),
                joinReq.getKindOfInsurance(),
                joinReq.getSsn()
        );
    }


    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPassword() {
        return password;
    }

    public String getInterestInsuranceId() {
        return interestInsuranceId;
    }

    public KindOfInsurance getKindOfInsurance() {
        return kindOfInsurance;
    }

    public String getAddress() {
        return address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public KindOfJob getKindOfJob() {
        return kindOfJob;
    }

    public String getSsn() {return ssn;}

    public void setSsn(String ssn) {this.ssn = ssn;}

    @Override
    public String toString() {
        return "CustomerJoinRequest{" +
                "customerId='" + customerId + '\'' +
                ", password='" + password + '\'' +
                ", interestInsuranceId=" + interestInsuranceId +
                ", name='" + name + '\'' +
                ", kindOfInsurance=" + kindOfInsurance +
                ", address='" + address + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", kindOfJob=" + kindOfJob +
                '}';
    }
}
