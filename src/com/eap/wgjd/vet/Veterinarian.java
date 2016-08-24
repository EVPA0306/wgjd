package com.eap.wgjd.vet;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by evgenypavlenko on 8/19/16.
 */
public class Veterinarian extends Thread {

    private final LinkedBlockingQueue<Appointment<Pet>> appts;
    //private String text = "";
    private final int restTime;
    private boolean shutdown = false;

    public Veterinarian(LinkedBlockingQueue<Appointment<Pet>> appts, int restTime) {
        this.appts = appts;
        this.restTime = restTime;
    }

    public synchronized void shutdown() {
        this.shutdown = true;
    }

    public void run() {
        while (!shutdown) {
            seePatient();
            try {
                Thread.sleep(restTime);
            } catch (InterruptedException iex) {
                shutdown = true;
            }
        }
    }

    private void seePatient() {
            try {

                Appointment<Pet> apt = appts.take();
                Pet patient = apt.getPatient();
                patient.examine();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

    }


}
