package com.heroes.votingsystem.service.impl;

import com.heroes.votingsystem.dto.PollRequestDTO;
import com.heroes.votingsystem.model.Option;
import com.heroes.votingsystem.model.Poll;
import com.heroes.votingsystem.model.PollResult;
import com.heroes.votingsystem.repository.OptionRepository;
import com.heroes.votingsystem.repository.PollRepository;
import com.heroes.votingsystem.repository.PollResultRepository;
import com.heroes.votingsystem.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollServiceImpl implements PollService {
    private final PollRepository pollRepository;
    private final OptionRepository optionRepository;
    private final PollResultRepository pollResultRepository;

    @Autowired
    public PollServiceImpl(PollRepository pollRepository, OptionRepository optionRepository,
                           PollResultRepository pollResultRepository) {
        this.pollRepository = pollRepository;
        this.optionRepository = optionRepository;
        this.pollResultRepository = pollResultRepository;
    }

    @Override
    public Poll createPollRequest(Poll pollRequest) {
        return pollRepository.save(pollRequest);

    }

    @Override
    public Poll getPollRequestById(Long id) {
        return pollRepository.findById(id).orElse(null);
    }

    @Override
    public List<Poll> getAllPollRequests() {
        return pollRepository.findAll();
    }

    @Override
    public Poll updatePollRequest(Long id, PollRequestDTO pollRequest) {
        Poll existingPoll = pollRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid poll ID: " + id));



        return pollRepository.save(existingPoll);
    }

    @Override
    public void deletePollRequest(Long id) {
        pollRepository.deleteById(id);
    }


    @Override
    public void vote(Long pollId, Long optionId) {
        Optional<Option> option = optionRepository.findById(optionId);
        if (option.isPresent()) {
            option.get().setVoteCount(option.get().getVoteCount() + 1);
            optionRepository.save(option.get());
        }
    }

    @Override
    public void calculateResults(Long pollId) {
        List<Option> options = optionRepository.findAllByPollId(pollId);
        int totalVotes = options.stream().mapToInt(Option::getVoteCount).sum();
        for (Option option : options) {
            double percentage = (double) option.getVoteCount() / totalVotes * 100;
            PollResult pollResult = new PollResult(null, option.getPoll(), option, option.getVoteCount());
            pollResultRepository.save(pollResult);
        }
    }
}
