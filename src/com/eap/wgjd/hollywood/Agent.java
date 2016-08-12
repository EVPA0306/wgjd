package com.eap.wgjd.hollywood;

/**
 * Created by evgenypavlenko on 8/12/16.
 */
public class Agent {

    private String name;
    private String type;

    public Agent(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
