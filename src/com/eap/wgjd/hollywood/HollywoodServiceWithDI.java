package com.eap.wgjd.hollywood;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evgenypavlenko on 8/12/16.
 */
public class HollywoodServiceWithDI {

    public static List<Agent> emailFriendlyAgents(AgentFinder finder) {

        List<Agent> agents = finder.findAllAgents();
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

        HollywoodServiceWithDI hollyWoodService = new HollywoodServiceWithDI();
        //System.out.println(hollyWoodService.emailFriendlyAgents().get(0).getName());
    }
}
