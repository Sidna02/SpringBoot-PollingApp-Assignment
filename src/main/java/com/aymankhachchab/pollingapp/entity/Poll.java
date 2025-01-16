package com.aymankhachchab.pollingapp.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
public class Poll  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Options> options;


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Options> getOptions() {
        return options;
    }
}
