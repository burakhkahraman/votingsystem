package com.heroes.votingsystem.repository;

import com.heroes.votingsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    List<Vote> findByPollId(Long pollId);

    List<Vote> findByOptionId(Long optionId);

    List<Vote> findByUserId(Long userId);
}
