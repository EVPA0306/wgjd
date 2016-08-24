package com.eap.wgjd.miscelaneos;

import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;

import java.util.Queue;
import java.util.Random;

/**
 * Created by evgenypavlenko on 8/21/16.
 */
public class Producer implements Runnable {

    private final Queue<Product> queue;
    private final Integer queueSize;

    public Producer(Queue queue, Integer queueSize) {
        this.queue = queue;
        this.queueSize = queueSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if(queue.size() < queueSize) {
                    queue.add(produce());
                    queue.notify();
                }
            }
        }
    }

    private synchronized Product produce() {
        Random r = new Random();
        Integer nextNumber = r.nextInt();
        return new Product(nextNumber.toString());
    }
}
