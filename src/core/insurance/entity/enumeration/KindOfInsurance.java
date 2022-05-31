package core.insurance.entity.enumeration;

public enum KindOfInsurance {
    LIFE(1, "LIFE"), NON_LIFE(2, "NON_LIFE");

    private int number;
    private String name;

    KindOfInsurance(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static KindOfInsurance getKindOfInsuranceBy(int number) {
        if(number == 1) return KindOfInsurance.LIFE;
        else return KindOfInsurance.NON_LIFE;
    }

}
