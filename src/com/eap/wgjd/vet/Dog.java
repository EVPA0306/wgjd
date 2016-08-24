package com.eap.wgjd.vet;

/**
 * Created by evgenypavlenko on 8/18/16.
 */
public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void examine() {
        System.out.println(name + ": Woof!");
    }

}
