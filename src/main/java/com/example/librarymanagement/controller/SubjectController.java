package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.Subject;
import com.example.librarymanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public String listSubjects(@RequestParam(name = "subjectId", required = false) Integer subjectId, Model model) {
        if (subjectId != null) {
            Subject subject = subjectService.getSubjectById(subjectId);
            if (subject != null) {
                model.addAttribute("subject", subject);
            } else {
                model.addAttribute("errorMessage", "Subject not found with ID: " + subjectId);
            }
        }
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "subjects";
    }

    @GetMapping("/viewAllSubjects")
    public String viewAllSubjects(Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "subjects";
    }

    @PostMapping("/addSubject")
    public String addSubject(@RequestParam String name, @RequestParam String description, Model model) {
        Subject newSubject = new Subject();
        newSubject.setName(name);
        newSubject.setDescription(description);
        subjectService.saveSubject(newSubject);
        model.addAttribute("successMessage", "Subject added successfully.");
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "subjects";
    }

    @PostMapping("/deleteSubject")
    public String deleteSubject(@RequestParam int subjectId, Model model) {
        subjectService.deleteSubjectById(subjectId);
        model.addAttribute("successMessage", "Subject deleted successfully.");
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "subjects";
    }
}
