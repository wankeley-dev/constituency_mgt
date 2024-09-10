package com.example.Learn.LearnOne.Repository;

import com.example.Learn.LearnOne.Entity.Welfare;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface WelfareRepository extends JpaRepository<Welfare, Long> {
    boolean existsByVoterId(String voterId);
    Optional<Welfare> findByVoterId(String voterId); // Method to find by voterId
}
