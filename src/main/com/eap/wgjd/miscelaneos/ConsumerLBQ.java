package com.eap.wgjd.miscelaneos;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by evgenypavlenko on 8/22/16.
 */
public class ConsumerLBQ implements Runnable {
    private final LinkedBlockingQueue<Product> queue;

    public ConsumerLBQ(LinkedBlockingQueue<Product> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void consume(Product product) {
        System.out.println(product.getName()+" queue size: " + queue.size());
    }
}
