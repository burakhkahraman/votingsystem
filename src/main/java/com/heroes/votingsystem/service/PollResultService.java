package com.heroes.votingsystem.service;

import com.heroes.votingsystem.model.PollResult;

import java.util.List;

public interface PollResultService {
    PollResult createPollResult(PollResult pollResult);
    List<PollResult> getAllPollResults();
    List<PollResult> getPollResultsByPollId(Long pollId);
    PollResult getPollResultById(Long id);

}
