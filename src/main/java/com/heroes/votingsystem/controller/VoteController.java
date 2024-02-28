package com.heroes.votingsystem.controller;

import com.heroes.votingsystem.model.Vote;
import com.heroes.votingsystem.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votes")
public class VoteController {
    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public void vote(@RequestParam Long pollId, @RequestParam Long optionId) {
        voteService.vote(pollId, optionId);
    }

    @GetMapping("/{id}")
    public Vote getVoteById(@PathVariable Long id) {
        return voteService.getVoteById(id);
    }

    @GetMapping
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    @GetMapping("/poll/{pollId}")
    public List<Vote> getVotesByPollId(@PathVariable Long pollId) {
        return voteService.getVotesByPollId(pollId);
    }

    @GetMapping("/option/{optionId}")
    public List<Vote> getVotesByOptionId(@PathVariable Long optionId) {
        return voteService.getVotesByOptionId(optionId);
    }

    @GetMapping("/user/{userId}")
    public List<Vote> getVotesByUserId(@PathVariable Long userId) {
        return voteService.getVotesByUserId(userId);
    }

    @PutMapping("/{id}")
    public Vote updateVote(@PathVariable Long id, @RequestBody Vote vote) {
        return voteService.updateVote(id, vote);
    }

    @DeleteMapping("/{id}")
    public void deleteVote(@PathVariable Long id) {
        voteService.deleteVote(id);
    }
}
