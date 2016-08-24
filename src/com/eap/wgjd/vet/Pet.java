package com.eap.wgjd.vet;


/**
 * Created by evgenypavlenko on 8/18/16.
 */
public abstract class Pet {
    protected final String name;

    public Pet(String name) {
        this.name = name;
    }
    public abstract void examine();
}
