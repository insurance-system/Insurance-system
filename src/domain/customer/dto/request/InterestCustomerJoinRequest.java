package domain.customer.dto.request;

import domain.customer.entity.Customer;
import domain.customer.enumeration.KindOfJob;
import domain.insurance.entity.enumeration.KindOfInsurance;

import static domain.customer.enumeration.KindOfJob.getKindOfJobBy;
import static domain.insurance.entity.enumeration.KindOfInsurance.getKindOfInsuranceBy;

public class InterestCustomerJoinRequest {

    private String name;
    private String address;
    private String detailAddress;
    private String zipcode;
    private String email;
    private KindOfJob kindOfJob;

    public InterestCustomerJoinRequest(
                    String name,
                    String address,
                    String detailAddress,
                    String zipcode,
                    String email,
                    int kindOfJobId) {
        this.name = name;
        this.address = address;
        this.detailAddress = detailAddress;
        this.zipcode = zipcode;
        this.email = email;
        this.kindOfJob = getKindOfJobBy(kindOfJobId);
    }

    public String getName() {
        return name;
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

    public KindOfJob getKindOfJob() {
        return kindOfJob;
    }

}
