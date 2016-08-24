package com.eap.wgjd.miscelaneos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by evgenypavlenko on 8/22/16.
 */
public class SetupLBQ {
    public static void main(String...args) {

        LinkedBlockingQueue<Product> queue = new LinkedBlockingQueue<>();

        ProducerLBQ producer = new ProducerLBQ(queue);
        ConsumerLBQ consumer = new ConsumerLBQ(queue);

        new Thread(producer, "Producer One").start();
        //new Thread(producer).start();

        new Thread(consumer, "Consumer One").start();
        new Thread(consumer, "Consumer Two").start();
        new Thread(consumer, "Consumer Three").start();
        new Thread(consumer, "Consumer Four").start();
        new Thread(consumer, "Consumer Five").start();
    }
}
