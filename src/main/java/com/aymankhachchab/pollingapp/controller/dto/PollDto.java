package com.aymankhachchab.pollingapp.controller.dto;

import com.aymankhachchab.pollingapp.entity.Options;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.List;


public class PollDto {
    @NotBlank()
    private String title;
    @Size(min = 2)
    private List<OptionsDto> options;

    public @NotBlank() String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank() String title) {
        this.title = title;
    }

    public @Size(min = 2) List<OptionsDto> getOptions() {
        return options;
    }

    public void setOptions(@Size(min = 2) List<OptionsDto> options) {
        this.options = options;
    }
}