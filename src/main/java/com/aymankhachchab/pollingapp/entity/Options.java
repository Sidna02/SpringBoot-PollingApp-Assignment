package com.aymankhachchab.pollingapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JsonIgnore
    private Poll poll;

    @OneToMany(mappedBy = "options", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vote> votes;

    @Transient
    private int votedCount;

    public int getVotedCount() {
        return votes != null ? votes.size() : 0;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Options(String name, Poll poll) {
        this.name = name;
        this.poll = poll;
        this.votes = new ArrayList<>();
    }

    public Options() {
        this.votes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public void setVotedCount(int votedCount) {
        this.votedCount = votedCount;
    }

    @Override
    public String toString() {
        return "Options{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", poll=" + poll +
                ", votes=" + votes +
                ", votedCount=" + votedCount +
                '}';
    }
}
