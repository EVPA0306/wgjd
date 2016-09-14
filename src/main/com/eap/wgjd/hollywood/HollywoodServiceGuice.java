package com.eap.wgjd.hollywood;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evgenypavlenko on 8/12/16.
 */
public class HollywoodServiceGuice {
    private AgentFinder agentFinder = null;

    @Inject
    public HollywoodServiceGuice(AgentFinder agentFinder) {
        this.agentFinder = agentFinder;
    }

    public List<Agent> getFriendlyAgents() {

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

}
