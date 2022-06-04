package domain.insurance.entity;

public class InsuranceCondition {
    private int maxAge;
    private int minAge;
    private String smoke;
    private String alcohol;
    private String cancer;

    public InsuranceCondition(int maxAge, int minAge, String smoke, String alcohol, String cancer) {
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.smoke = smoke;
        this.alcohol = alcohol;
        this.cancer = cancer;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }
}
