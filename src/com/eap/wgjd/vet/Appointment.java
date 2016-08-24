package com.eap.wgjd.vet;

/**
 * Created by evgenypavlenko on 8/19/16.
 */
public class Appointment<T> {
    private final T toBeSeen;

    public Appointment(T toBeSeen) {
        this.toBeSeen = toBeSeen;
    }

    public T getPatient() {
        return toBeSeen;
    }

}
