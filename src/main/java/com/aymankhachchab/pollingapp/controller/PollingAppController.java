package com.aymankhachchab.pollingapp.controller;

import com.aymankhachchab.pollingapp.controller.dto.OptionsDto;
import com.aymankhachchab.pollingapp.controller.dto.PollDto;
import com.aymankhachchab.pollingapp.controller.dto.VoteDto;
import com.aymankhachchab.pollingapp.entity.Options;
import com.aymankhachchab.pollingapp.entity.Poll;
import com.aymankhachchab.pollingapp.entity.Vote;
import com.aymankhachchab.pollingapp.respository.OptionsRepository;
import com.aymankhachchab.pollingapp.respository.PollRepository;
import com.aymankhachchab.pollingapp.respository.VoteRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PollingAppController {
    private final PollRepository pollRepository;
    private final OptionsRepository optionsRepository;
    private final VoteRepository voteRepository;

    public PollingAppController(@Autowired PollRepository pollRepository,

                                @Autowired OptionsRepository optionsRepository,
                                 @Autowired VoteRepository voteRepository) {
        this.pollRepository = pollRepository;
        this.optionsRepository = optionsRepository;
        this.voteRepository = voteRepository;
    }

    @PostMapping("/poll")
    public ResponseEntity<?> createPoll(@Valid @RequestBody PollDto pollDto) {

        Poll poll  = new Poll();
        poll.setTitle(pollDto.getTitle());
        List<Options> optionsList = new ArrayList<>();
        for( OptionsDto option : pollDto.getOptions() ) {
            optionsList.add(new Options(option.getName(), poll));

        }
        poll.setOptions(optionsList);

        return new ResponseEntity<>(pollRepository.saveAndFlush(poll), HttpStatus.CREATED);
    }
    @GetMapping("/poll")
    public ResponseEntity<List<Poll>> getPolls() {
        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/poll/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable @NotNull Long id) {

        Poll poll = pollRepository.findById(id).orElseThrow();

        return new ResponseEntity<>(poll, HttpStatus.OK);
    }
    @PostMapping("/vote")
    public ResponseEntity<VoteDto> vote(@Valid @RequestBody VoteDto voteDto) {
        Options option = this.optionsRepository.findById(voteDto.getOptionId()).orElseThrow();

       option.getVotes().add(new Vote(option));
        optionsRepository.saveAndFlush(option);
        return new ResponseEntity<>(voteDto, HttpStatus.OK);
    }
}
