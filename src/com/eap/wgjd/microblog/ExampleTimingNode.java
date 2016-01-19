package com.eap.wgjd.microblog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by evgenypavlenko on 1/19/16.
 */
public class ExampleTimingNode extends SimpleMicroBlog {
    private final String identifier;
    private final Map<Update, Long> arrivalTime = new HashMap<>();

    public ExampleTimingNode(String identifier) {
        this.identifier = identifier;
    }

    public synchronized String getIdentifier() {
        return this.identifier;
    }

    public synchronized void propagateUpdate(Update update) {
        long currentTime = System.currentTimeMillis();
        arrivalTime.put(update,currentTime);
    }

    public synchronized boolean confirmUpdateRecevied(Update update) {
        Long timeRecvd = arrivalTime.get(update);
        return timeRecvd != null;
    }
}
