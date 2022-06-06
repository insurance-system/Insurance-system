package domain.customer.dto.request;

public class InterestCustomerJoinRequest {

    private String address;
    private String detailAddress;
    private String zipcode;
    private String email;

    public InterestCustomerJoinRequest(
                    String address,
                    String detailAddress,
                    String zipcode,
                    String email) {
        this.address = address;
        this.detailAddress = detailAddress;
        this.zipcode = zipcode;
        this.email = email;
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


}
