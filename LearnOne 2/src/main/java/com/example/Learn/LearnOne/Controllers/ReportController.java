package com.example.Learn.LearnOne.Controllers;

import com.example.Learn.LearnOne.Services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public String viewReport(Model model) {
        // Fetch total numbers for the report
        int totalBeneficiaries = reportService.getTotalBeneficiaries();
        int totalVoters = reportService.getTotalVoters();

        // Add attributes for the view
        model.addAttribute("totalBeneficiaries", totalBeneficiaries);
        model.addAttribute("totalVoters", totalVoters);

        return "report"; // Ensure this matches your Thymeleaf template
    }
}
