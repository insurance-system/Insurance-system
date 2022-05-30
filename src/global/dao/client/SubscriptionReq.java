package global.dao.client;

public class SubscriptionReq {
    private String clientId;
    private ClientHealthInformation clientHealthInformation;



    private boolean isLife;

    public ClientHealthInformation getClientHealthInformation() {
        return clientHealthInformation;
    }

    public String getClientId() {
        return clientId;
    }

    public boolean isLife() {
        return isLife;
    }

    public void setLife(boolean life) {
        isLife = life;
    }
}
