package domain.customer.entity;

import java.util.Date;

public class FindPayment {
    private String insuranceName;
    private int fee;

    public FindPayment(String insuranceName, int fee, String payDate) {
        this.insuranceName = insuranceName;
        this.fee = fee;
        this.payDate = payDate;
    }

    private String payDate;



    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
}
