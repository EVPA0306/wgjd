package com.eap.wgjd.hollywood;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evgenypavlenko on 8/12/16.
 */
public class HollyWoodServiceWithFactory {

    public List<Agent> getFriendlyAgents(String agentFinderType) {

        AgentFinderFactory factory = AgentFinderFactory.getInstance();
        AgentFinder agentFinder = factory.getAgentFinder(agentFinderType);
        List<Agent> agents = agentFinder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents,"Java Developer");
        return friendlyAgents;
    }

    private static List<Agent> filterAgents(List<Agent> agents, String agentType) {
        List<Agent> filteredAgents = new ArrayList<>();
        for (Agent agent : agents) {
            if (agentType.equals(agent.getType()) ) {
                filteredAgents.add(agent);
            }
        }
        return filteredAgents;
    }

    public static void main(String ...args) {

        HollyWoodServiceWithFactory hollyWoodService = new HollyWoodServiceWithFactory();
        System.out.println(hollyWoodService.getFriendlyAgents("SpreadSheetAgentFinder").get(0).getName());
    }
}
