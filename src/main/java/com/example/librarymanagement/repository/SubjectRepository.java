package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
