package com.heroes.votingsystem.service;

import com.heroes.votingsystem.model.Vote;

import java.util.List;

public interface VoteService {
    void vote(Long pollId, Long optionId);
    Vote getVoteById(Long id);
    List<Vote> getAllVotes();
    List<Vote> getVotesByPollId(Long pollId);
    List<Vote> getVotesByOptionId(Long optionId);
    List<Vote> getVotesByUserId(Long userId);
    Vote updateVote(Long id, Vote vote);
    void deleteVote(Long id);
}
