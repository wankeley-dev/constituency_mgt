package com.example.Learn.LearnOne.Repository;

import com.example.Learn.LearnOne.Entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository // Optional, but good practice
public interface VoterRepository extends JpaRepository<Voter, Long> {
    boolean existsByVoterId(String voterId); // New method to check for existing voter ID

    Optional<Voter> findByVoterId(String voterId);
}