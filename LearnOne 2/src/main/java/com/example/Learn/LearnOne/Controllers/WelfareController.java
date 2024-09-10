package com.example.Learn.LearnOne.Controllers;

import com.example.Learn.LearnOne.Entity.Welfare;
import com.example.Learn.LearnOne.Services.WelfareService;
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
@RequestMapping("/welfareInput")
public class WelfareController {

    @Autowired
    private WelfareService welfareService;

    @GetMapping
    public String showWelfareForm(Model model) {
        model.addAttribute("welfare", new Welfare());
        return "welfareInput"; // Ensure this matches your Thymeleaf template
    }

    @PostMapping("/save")
    public String saveWelfare(@Valid Welfare welfare, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "welfareInput"; // Return to form if there are errors
        }

        welfareService.saveOrUpdateWelfare(welfare);
        redirectAttributes.addFlashAttribute("message", "Welfare information saved successfully!"); // Add success message
        return "redirect:/welfareInput"; // Redirect back to the form after saving
    }

    @GetMapping("/view")
    public String viewWelfareInformation(Model model) {
        model.addAttribute("welfares", welfareService.findAllWelfares());
        return "welfareView"; // Ensure this matches your Thymeleaf template for viewing welfare information
    }
}
