package com.heroes.votingsystem.repository;

import com.heroes.votingsystem.model.PollResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollResultRepository extends JpaRepository<PollResult, Long> {
    List<PollResult> findByPollId(Long pollId);
}
