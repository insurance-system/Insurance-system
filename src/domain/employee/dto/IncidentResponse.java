package domain.employee.dto;

public class IncidentResponse {
    private String incidentId;
    private String name;
    private String phoneNum;
    private String date;
    private String address;

    public IncidentResponse(String incidentId, String name, String phoneNum, String date, String address) {
        this.incidentId = incidentId;
        this.name = name;
        this.phoneNum = phoneNum;
        this.date = date;
        this.address = address;
    }
    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
