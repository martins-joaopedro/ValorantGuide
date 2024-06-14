package com.valorant.valorantguide.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.valorant.valorantguide.client.ValorantService;
import com.valorant.valorantguide.dto.AgentDTO;
import com.valorant.valorantguide.services.AgentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController()
@RequestMapping("/agents")
public class AgentController {

    // Singleton Design Pattern : durante a execução será mantida uma única instância desse objeto  
    @Autowired
    AgentService agentService;
    
    @GetMapping
    public List<AgentDTO> findAllAgents() {

        return agentService.findAllAgents();
    }

    @PostMapping
    public List<AgentDTO> findAgentsByRole(@RequestBody Request req) {
        
        return agentService.findAgentsByRole(req.role());
    }
    
    record Request(String role) {};
}
