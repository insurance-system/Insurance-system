package core.insurance.entity;

import global.entity.Compensation;

public abstract class Insurance {
    private String id;
    private String name;
    private String fee;
    private Compensation compensation;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFee() {
        return fee;
    }

    public Compensation getCompensation() {
        return compensation;
    }

    //TODO
    public static Insurance makeObject(String insuranceStr) {
        return null;
    }
}
