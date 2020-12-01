package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "agentId"
})
@XmlRootElement(name = "Agent")
public class Agent implements ConnectElement {

    @XmlValue
    protected String agentId;

    public static AgentBuilder builder() {
        return new AgentBuilder();
    }

    public Agent() {
    }

    public Agent(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentId() {
        return agentId;
    }


    public void setAgentId(String value) {
        this.agentId = value;
    }
}
