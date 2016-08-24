package com.eap.wgjd.vet;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by evgenypavlenko on 8/19/16.
 */
public class VetClinic {
    public static void main(String ...args) throws InterruptedException{

        Appointment<Pet> appointmentSony = new Appointment<>(new Cat("Sony"));
        Appointment<Pet> appointmentSpark = new Appointment<>(new Dog("Spark"));

        //Create a queue
        LinkedBlockingQueue<Appointment<Pet>> appointmentQueue = new LinkedBlockingQueue<Appointment<Pet>>();
        //Add pets
        appointmentQueue.put(appointmentSony);
        appointmentQueue.put(appointmentSpark);

        //Create Vet
        Veterinarian vetOne = new Veterinarian(appointmentQueue,3000);
        vetOne.start();
    }
}
