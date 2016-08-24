package com.eap.wgjd.miscelaneos;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created by evgenypavlenko on 8/22/16.
 */
public class ConsumerTQ implements Runnable {
    private final TransferQueue<Product> queue;

    public ConsumerTQ(TransferQueue<Product> queue) {
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
