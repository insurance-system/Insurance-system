package domain.employee.dto;

import domain.insurance.entity.enumeration.KindOfInsurance;

import java.util.ArrayList;

public class CustomerAnalysisInformation {

    private String InsuranceName;
    private KindOfInsurance kindOfInsurance;
    private String avg;
    private String cnt;

    public CustomerAnalysisInformation(String insuranceName, KindOfInsurance kindOfInsurance, String avg, String cnt) {
        InsuranceName = insuranceName;
        this.kindOfInsurance = kindOfInsurance;
        this.avg = avg;
        this.cnt = cnt;
    }

    public String getInsuranceName() {
        return InsuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        InsuranceName = insuranceName;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        cnt = cnt;
    }
}
