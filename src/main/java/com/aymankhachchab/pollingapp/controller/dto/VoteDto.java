package com.aymankhachchab.pollingapp.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class VoteDto  {
    @NotNull
    private Long optionId;

    public @NotNull Long getOptionId() {
        return optionId;
    }

    public void setOptionId(@NotNull Long optionId) {
        this.optionId = optionId;
    }
}
