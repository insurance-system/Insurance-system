package domain.customer.entity;

public class HealthInformation {
    private int healthInformationId;
    private Grade cancer;
    private Grade smoke;
    private Grade alcohol;

    public int getHealthInformationId() {
        return healthInformationId;
    }

    public void setHealthInformationId(int healthInformationId) {
        this.healthInformationId = healthInformationId;
    }

    public Grade getCancer() {
        return cancer;
    }

    public void setCancer(Grade cancer) {
        this.cancer = cancer;
    }

    public Grade getSmoke() {
        return smoke;
    }

    public void setSmoke(Grade smoke) {
        this.smoke = smoke;
    }

    public Grade getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Grade alcohol) {
        this.alcohol = alcohol;
    }
}
