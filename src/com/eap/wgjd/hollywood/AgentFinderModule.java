package com.eap.wgjd.hollywood;

import com.google.inject.AbstractModule;

/**
 * Created by evgenypavlenko on 8/12/16.
 */
public class AgentFinderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AgentFinder.class).to(SpreadSheetAgentFinder.class);
    }
}
