package com.example.Learn.LearnOne.Services;

import com.example.Learn.LearnOne.Entity.Welfare;
import com.example.Learn.LearnOne.Entity.Voter;
import com.example.Learn.LearnOne.Repository.WelfareRepository;
import com.example.Learn.LearnOne.Repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private WelfareRepository welfareRepository;

    @Autowired
    private VoterRepository voterRepository;

    public int getTotalBeneficiaries() {
        return (int) welfareRepository.count(); // Adjust as per your logic
    }

    public int getTotalVoters() {
        return (int) voterRepository.count(); // Adjust as per your logic
    }


}
