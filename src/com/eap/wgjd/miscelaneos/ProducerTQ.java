package com.eap.wgjd.miscelaneos;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created by evgenypavlenko on 8/22/16.
 */
public class ProducerTQ implements Runnable {

    private final TransferQueue<Product> queue;


    public ProducerTQ(TransferQueue queue) {
        this.queue = queue;

    }

    @Override
    public void run() {
        try {
            while (true) {
                queue.transfer(produce());
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private Product produce() {
        Random r = new Random();
        Integer nextNumber = r.nextInt();
        return new Product(nextNumber.toString());
    }
}
