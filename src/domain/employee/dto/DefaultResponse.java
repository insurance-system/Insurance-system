package domain.employee.dto;

public class DefaultResponse {

    private String customerId;
    private String name;
    private String phoneNumber;
    private String address;
    private String detailAddress;
    private String zipCode;
    private String insuranceName;
    private String contractStatus;

    public DefaultResponse(String customerId, String name, String phoneNumber, String address, String detailAddress, String zipCode, String insuranceName, String contractStatus) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.detailAddress = detailAddress;
        this.zipCode = zipCode;
        this.insuranceName = insuranceName;
        this.contractStatus = contractStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public String getContractStatus() {
        return contractStatus;
    }
}
