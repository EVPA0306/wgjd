package com.eap.wgjd.patterns;

/**
 * Created by evgenypavlenko on 8/15/16.
 */
public class CreateACar {
    public static void main(String...args) {
        Car.CarBuilder cb = new Car.CarBuilder();
        Car car = cb.carName("GLK350").modelYear("2012").mileage("9650").build();
        System.out.println(car);
    }
}
