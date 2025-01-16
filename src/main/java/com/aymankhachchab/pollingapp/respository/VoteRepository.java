package com.aymankhachchab.pollingapp.respository;

import com.aymankhachchab.pollingapp.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}