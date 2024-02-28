package com.heroes.votingsystem.service.impl;

import com.heroes.votingsystem.model.PollResult;
import com.heroes.votingsystem.repository.PollResultRepository;
import com.heroes.votingsystem.service.PollResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollResultServiceImpl implements PollResultService {
    private final PollResultRepository pollResultRepository;

    @Autowired
    public PollResultServiceImpl(PollResultRepository pollResultRepository) {
        this.pollResultRepository = pollResultRepository;
    }

    @Override
    public PollResult createPollResult(PollResult pollResult) {
        return pollResultRepository.save(pollResult);
    }

    @Override
    public List<PollResult> getAllPollResults() {
        return pollResultRepository.findAll();
    }

    @Override
    public List<PollResult> getPollResultsByPollId(Long pollId) {
        return pollResultRepository.findByPollId(pollId);
    }
    @Override
    public PollResult getPollResultById(Long id) {
        return pollResultRepository.findById(id).orElse(null);
    }
}
