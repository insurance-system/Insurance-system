package global.entity;

public class Address {
    private String address;
    private String detailAddress;
    private String zipcode;

    @Override
    public String toString() {
        return this.getAddress()+"/"+this.getDetailAddress()+"/"+this.getZipcode();
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
}
