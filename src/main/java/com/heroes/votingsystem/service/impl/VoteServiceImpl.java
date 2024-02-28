package com.heroes.votingsystem.service.impl;

import com.heroes.votingsystem.model.Option;
import com.heroes.votingsystem.model.Vote;
import com.heroes.votingsystem.repository.OptionRepository;
import com.heroes.votingsystem.repository.VoteRepository;
import com.heroes.votingsystem.service.VoteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    private final OptionRepository optionRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository, OptionRepository optionRepository) {
        this.voteRepository = voteRepository;
        this.optionRepository = optionRepository;
    }

    @Override
    @Transactional
    public void vote(Long pollId, Long optionId) {
        // Seçeneğin veritabanından alınması
        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid option ID: " + optionId));

        // Seçeneğin ilgili ankete ait olup olmadığının kontrol edilmesi
        if (!option.getPoll().getId().equals(pollId)) {
            throw new IllegalArgumentException("Option with ID " + optionId + " does not belong to poll with ID " + pollId);
        }

        // Oy verme işlemi
        option.setVoteCount(option.getVoteCount() + 1);
        optionRepository.save(option);
    }

    @Override
    public Vote getVoteById(Long id) {
        return voteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public List<Vote> getVotesByPollId(Long pollId) {
        return voteRepository.findByPollId(pollId);
    }

    @Override
    public List<Vote> getVotesByOptionId(Long optionId) {
        return voteRepository.findByOptionId(optionId);
    }

    @Override
    public List<Vote> getVotesByUserId(Long userId) {
        return voteRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public Vote updateVote(Long id, Vote vote) {
        Vote existingVote = voteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vote ID: " + id));

        return voteRepository.save(existingVote);
    }

    @Override
    @Transactional
    public void deleteVote(Long id) {
        voteRepository.deleteById(id);
    }
}
