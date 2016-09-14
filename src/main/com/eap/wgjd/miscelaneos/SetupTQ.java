package com.eap.wgjd.miscelaneos;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created by evgenypavlenko on 8/22/16.
 */
public class SetupTQ {
    public static void main(String...args) {

        TransferQueue<Product> queue = new LinkedTransferQueue<>();

        ProducerTQ producer = new ProducerTQ(queue);
        ConsumerTQ consumer = new ConsumerTQ(queue);

        new Thread(producer, "Producer One").start();
        new Thread(producer, "Producer Two").start();
        //new Thread(producer).start();

        new Thread(consumer, "Consumer One").start();
        new Thread(consumer, "Consumer Two").start();
        new Thread(consumer, "Consumer Three").start();
        new Thread(consumer, "Consumer Four").start();
        new Thread(consumer, "Consumer Five").start();
    }
}
