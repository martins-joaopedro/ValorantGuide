package com.valorant.valorantguide.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.valorant.valorantguide.client.ValorantService;
import com.valorant.valorantguide.dto.AgentDTO;

// Strategy Design Pattern : implementa os métodos da interface
public class AgentServiceImp implements AgentService {

    @Autowired
    ValorantService valorantService;

    @Override
    public List<AgentDTO> findAllAgents() {
        
        return valorantService.getData();
    }

    @Override
    public List<AgentDTO> findAgentsByRole(String role) {
    
        List<AgentDTO> agents = valorantService.getData();
        
        agents
            .stream()
            .filter(agent -> agent.getRole().equalsIgnoreCase(role));

        return agents;
    }
    
}
