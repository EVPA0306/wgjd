package com.eap.wgjd.vet;

/**
 * Created by evgenypavlenko on 8/18/16.
 */
public class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void examine() {
        System.out.println(name + ": Meow!");
    }
}
