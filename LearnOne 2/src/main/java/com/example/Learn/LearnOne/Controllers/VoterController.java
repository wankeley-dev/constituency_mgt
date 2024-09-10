package com.example.Learn.LearnOne.Controllers;

import com.example.Learn.LearnOne.Entity.Voter;
import com.example.Learn.LearnOne.Repository.VoterRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/voterInput")
public class VoterController {

    @Autowired
    private VoterRepository voterRepository;

    @GetMapping
    public String showVoterForm(Model model) {
        model.addAttribute("voter", new Voter());
        return "voterInput"; // Ensure this matches your Thymeleaf template
    }

    @PostMapping("/save")
    public String saveVoter(@Valid Voter voter, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "voterInput"; // Return to form if there are errors
        }

        if (voterRepository.existsByVoterId(voter.getVoterId())) {
            // Handle duplicate voterId case
            result.rejectValue("voterId", "error.voterId", "Voter ID already exists.");
            return "voterInput";
        }

        voterRepository.save(voter);
        redirectAttributes.addFlashAttribute("message", "Voter information saved successfully!"); // Add success message
        return "redirect:/voterInput"; // Redirect back to the form after saving
    }

    @GetMapping("/view")
    public String viewVoterInformation(Model model) {
        model.addAttribute("voters", voterRepository.findAll());
        return "voterView"; // Ensure this matches your Thymeleaf template for viewing voters
    }
}