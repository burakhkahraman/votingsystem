package com.heroes.votingsystem.controller;

import com.heroes.votingsystem.model.PollResult;
import com.heroes.votingsystem.service.PollResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/poll-results")
public class PollResultController {
    private final PollResultService pollResultService;

    @Autowired
    public PollResultController(PollResultService pollResultService) {
        this.pollResultService = pollResultService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PollResult> getPollResultById(@PathVariable Long id) {
        PollResult pollResult = pollResultService.getPollResultById(id);
        return ResponseEntity.ok(pollResult);
    }

    @GetMapping("/poll/{pollId}")
    public ResponseEntity<List<PollResult>> getPollResultsByPollId(@PathVariable Long pollId) {
        List<PollResult> pollResults = pollResultService.getPollResultsByPollId(pollId);
        return ResponseEntity.ok(pollResults);
    }
}
