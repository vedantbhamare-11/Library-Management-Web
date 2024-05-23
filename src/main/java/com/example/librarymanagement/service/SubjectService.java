package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Subject;
import com.example.librarymanagement.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(int id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubjectById(int id) {
        subjectRepository.deleteById(id);
    }
}
