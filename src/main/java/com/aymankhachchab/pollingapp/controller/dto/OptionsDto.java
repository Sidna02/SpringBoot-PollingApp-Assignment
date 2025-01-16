package com.aymankhachchab.pollingapp.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;



public class OptionsDto {
    @NotBlank
    private String name;


    public @NotBlank String getName() {
        return name;
    }

}