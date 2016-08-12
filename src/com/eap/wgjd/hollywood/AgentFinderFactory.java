package com.eap.wgjd.hollywood;

/**
 * Created by evgenypavlenko on 8/12/16.
 */
public class AgentFinderFactory {

    private static AgentFinderFactory instance;
    private AgentFinderFactory() {}

    public static AgentFinderFactory getInstance() {
        if (instance == null) {
            instance = new AgentFinderFactory();
        }
        return instance;
    }

    public AgentFinder getAgentFinder(String agentFinderType) {
        AgentFinder agentFinder = null;

        if("SpreadSheetAgentFinder".equals(agentFinderType)) {
            agentFinder = new SpreadSheetAgentFinder();
        }
        return agentFinder;
    }
}
