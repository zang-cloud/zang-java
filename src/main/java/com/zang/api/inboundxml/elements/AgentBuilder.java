package com.zang.api.inboundxml.elements;

public class AgentBuilder {
    private String agentId;

    AgentBuilder() {
    }

    /**
     * The Agent ID.
     * @param agentId
     * @return
     */
    public AgentBuilder setAgentId(String agentId) {
        this.agentId = agentId;
        return this;
    }

    public Agent build() {
        return new Agent(agentId);
    }
}