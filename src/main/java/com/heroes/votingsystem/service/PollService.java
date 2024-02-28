package com.heroes.votingsystem.service;

import com.heroes.votingsystem.dto.PollRequestDTO;
import com.heroes.votingsystem.model.Poll;

import java.util.List;

public interface PollService {
    Poll createPollRequest(Poll pollRequest);
    Poll getPollRequestById(Long id);
    List<Poll> getAllPollRequests();
    Poll updatePollRequest(Long id, PollRequestDTO pollRequest);
    void deletePollRequest(Long id);


    void vote(Long pollId, Long optionId);
    void calculateResults(Long pollId);
}
