package com.valorant.valorantguide.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.valorant.valorantguide.dto.AbilitiesDTO;
import com.valorant.valorantguide.dto.AgentDTO;

// Facade Design Pattern : faz o trabalho intermédiário retirando complexidades
@FeignClient(name = "valorant", url = "https://valorant-api.com/v1")
public interface ValorantService {

    @GetMapping("/agents")
    Response get();

    default List<AgentDTO> getData() {
        
        // Strategy Design Pattern
        List<AgentDTO> agents = new ArrayList<>();
        Response response = get();

        response
            .data()
            .stream()
            .filter(data -> data.isPlayableCharacter())
            .forEach(data -> {

                List<AbilitiesDTO> abilitesList = new ArrayList<>();    
                data.abilities().stream().forEach(
                    ability -> abilitesList.add(new AbilitiesDTO(ability.displayName(), ability.description()))
                );    
                
                agents.add(
                    new AgentDTO(
                        data.displayName(), 
                        data.role().displayName(),
                        data.role().description(),
                        abilitesList
                    )
                );
            });

        return agents;
    }

    record Response(List<Agent> data) {};
    record Agent(String displayName, Boolean isPlayableCharacter, Role role, List<Abilities> abilities) {};
    record Role(String displayName, String description) {};
    record Abilities(String displayName, String description) {};
}
