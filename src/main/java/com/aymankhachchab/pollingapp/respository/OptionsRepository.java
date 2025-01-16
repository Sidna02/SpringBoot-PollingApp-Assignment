package com.aymankhachchab.pollingapp.respository;

import com.aymankhachchab.pollingapp.entity.Options;
import com.aymankhachchab.pollingapp.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionsRepository extends JpaRepository<Options, Long> {
}