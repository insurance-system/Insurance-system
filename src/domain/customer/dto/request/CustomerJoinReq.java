package domain.customer.dto.request;

import global.entity.Address;

public class CustomerJoinReq {
    private String id;
    private String name;
    private String ssn;
    private Address address;
    private String sex;
    private String phoneNumber;

    @Override
    public String toString() {
        return
                this.getId()+" " +
                        this.getName()+" "+
                        this.getSsn()+" "+
                        this.getAddress()+" "+
                        this.getSex()+" "+
                        this.getPhoneNumber();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public Address getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
