package com.heroes.votingsystem.controller;

import com.heroes.votingsystem.model.Poll;
import com.heroes.votingsystem.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
public class PollController {
    private final PollService pollService;

    @Autowired
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPollRequest(poll);
    }

    @GetMapping("/{id}")
    public Poll getPollById(@PathVariable Long id) {
        return pollService.getPollRequestById(id);
    }

    @GetMapping
    public List<Poll> getAllPolls() {
        return pollService.getAllPollRequests();
    }

    @PutMapping("/{id}")
    public Poll updatePoll(@PathVariable Long id, @RequestBody Poll poll) {
        return pollService.updatePollRequest(id, poll);
    }

    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable Long id) {
        pollService.deletePollRequest(id);
    }
}
