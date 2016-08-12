package com.eap.wgjd.hollywood;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evgenypavlenko on 8/12/16.
 */
public class SpreadSheetAgentFinder implements AgentFinder {

    public String getType() {
        return "SpreadSheetAgentFinder";
    }

    @Override
    public List<Agent> findAllAgents() {
        List<Agent> allSsAgents = new ArrayList<>();
        allSsAgents.add(new Agent("John Smith","Java Developer"));
        allSsAgents.add(new Agent("Peter Penn","C# Developer"));
        allSsAgents.add(new Agent("Ivan Ivanov","Java Developer"));
        return allSsAgents;
    }
}
