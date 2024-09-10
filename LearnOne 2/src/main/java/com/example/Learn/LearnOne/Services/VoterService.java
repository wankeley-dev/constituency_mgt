package com.example.Learn.LearnOne.Services;

import com.example.Learn.LearnOne.Entity.Voter;
import com.example.Learn.LearnOne.Repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    public void saveVoter(Voter voter) {
        voterRepository.save(voter);
    }

    public Optional<Voter> getVoter(String voterId) {
        return voterRepository.findByVoterId(voterId);
    }

    @Override
    public String toString() {
        return "VoterService{" + "voterRepository=" + voterRepository + '}';
    }


    public List<Voter> findAllVoters() {
        return voterRepository.findAll();
    }
}