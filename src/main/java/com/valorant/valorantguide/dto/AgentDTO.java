package com.valorant.valorantguide.dto;

import java.util.List;

public class AgentDTO {

    private String name;
    private String role;
    private String roleDescription;
    private List<AbilitiesDTO> abilities;

    public AgentDTO(String name, String role, String roleDescription, List<AbilitiesDTO> abilities) {
        this.name = name;
        this.role = role;
        this.roleDescription = roleDescription ;
        this.abilities = abilities;
    }

    public List<AbilitiesDTO> getAbilities() {
        return abilities;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
    
    public String getRoleDescription() {
        return roleDescription;
    }
}
