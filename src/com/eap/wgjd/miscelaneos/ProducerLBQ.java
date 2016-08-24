package com.eap.wgjd.miscelaneos;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by evgenypavlenko on 8/22/16.
 */
public class ProducerLBQ implements Runnable {

    private final LinkedBlockingQueue<Product> queue;


    public ProducerLBQ(LinkedBlockingQueue queue) {
        this.queue = queue;

    }

    @Override
    public void run() {
        try {
            while (true) {
                queue.put(produce());
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
