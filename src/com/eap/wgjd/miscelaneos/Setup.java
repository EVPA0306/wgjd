package com.eap.wgjd.miscelaneos;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by evgenypavlenko on 8/21/16.
 */
public class Setup {
    public static void main(String...args) {

        Queue<Product> queue = new LinkedList<Product>();

        Producer producer = new Producer(queue, 100);
        Consumer consumer = new Consumer(queue);

        new Thread(producer, "Producer One").start();
        //new Thread(producer).start();

        new Thread(consumer, "Consumer One").start();
        new Thread(consumer, "Consumer Two").start();
        new Thread(consumer, "Consumer Three").start();
        new Thread(consumer, "Consumer Four").start();
        new Thread(consumer, "Consumer Five").start();
    }
}
