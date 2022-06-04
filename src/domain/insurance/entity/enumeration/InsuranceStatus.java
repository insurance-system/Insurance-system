package domain.insurance.entity.enumeration;

public enum InsuranceStatus {
    ALLOWANCE(1, "허가"),
    DISALLOWANCE(2,"불허"),
    UNDERREVIEW(3,"심사중");

    private int number;
    private String name;

    InsuranceStatus(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static InsuranceStatus setInsuranceStatusBy(String name) {
        if(name.equals(InsuranceStatus.ALLOWANCE.name)) return ALLOWANCE;
        else if (name.equals(InsuranceStatus.DISALLOWANCE.name)) return DISALLOWANCE;
        else return UNDERREVIEW;
    }

}
