package com.example.Learn.LearnOne.Services;

import com.example.Learn.LearnOne.Entity.Welfare;
import com.example.Learn.LearnOne.Repository.WelfareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WelfareService {

    @Autowired
    private WelfareRepository welfareRepository;

    // Save or update welfare record based on voterId
    public Welfare saveOrUpdateWelfare(Welfare welfare) {
        Optional<Welfare> existingWelfareOpt = welfareRepository.findByVoterId(welfare.getVoterId());
        if (existingWelfareOpt.isPresent()) {
            Welfare existingWelfare = existingWelfareOpt.get();
            existingWelfare.setName(welfare.getName());
            existingWelfare.setWard(welfare.getWard());
            existingWelfare.setAmountPaid(welfare.getAmountPaid());
            existingWelfare.setStartDate(welfare.getStartDate());
            return welfareRepository.save(existingWelfare);
        } else {
            return welfareRepository.save(welfare);
        }
    }

    // Find all welfare records
    public List<Welfare> findAllWelfares() {
        return welfareRepository.findAll();
    }

    // Check if welfare record exists by voterId
    public boolean existsByVoterId(String voterId) {
        return welfareRepository.existsByVoterId(voterId);
    }
}
