package com.eap.wgjd.miscelaneos;

import java.util.Queue;

/**
 * Created by evgenypavlenko on 8/21/16.
 */
public class Consumer implements Runnable {

    private final Queue<Product> queue;

    public Consumer(Queue<Product> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
                while (true) {
                    synchronized (queue) {
                        consume(queue.poll());
                        queue.wait();
                    }
                }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
     }

    private synchronized void consume(Product product) {
        System.out.println(product.getName()+" queue size: " + queue.size());
    }
}
