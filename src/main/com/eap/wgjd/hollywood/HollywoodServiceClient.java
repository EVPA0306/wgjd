package com.eap.wgjd.hollywood;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by evgenypavlenko on 8/12/16.
 */
public class HollywoodServiceClient {
    public static void main(String...args) {
        Injector injector = Guice.createInjector(new AgentFinderModule());
        HollywoodServiceGuice hollywoodServiceGuice = injector.getInstance(HollywoodServiceGuice.class);
        System.out.println(hollywoodServiceGuice.getFriendlyAgents().get(1).getName());
    }
}
