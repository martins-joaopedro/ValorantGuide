package com.valorant.valorantguide.dto;

public class AbilitiesDTO {

    private String name;
    private String description;

    public AbilitiesDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
}