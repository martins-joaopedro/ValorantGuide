package com.valorant.valorantguide.services;

import java.util.List;

import com.valorant.valorantguide.dto.AgentDTO;

public interface AgentService {

    public List<AgentDTO> findAllAgents();

    public List<AgentDTO> findAgentsByRole(String role);
}
