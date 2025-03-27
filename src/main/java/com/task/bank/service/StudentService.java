package com.task.bank.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.task.bank.entity.Student;
import com.task.bank.repository.StudentRepository;
import com.task.bank.util.ExcelUpload;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String saveStudentsFromExcel(MultipartFile file) {
        if (!ExcelUpload.hasExcelFormat(file)) {
            throw new IllegalArgumentException("Invalid file format. Please upload an Excel file.");
        }

        try {
            List<Student> students = ExcelUpload.parseExcel(file.getInputStream());
            Set<String> rollNumbers = new HashSet<>();

            // Filter out duplicates before saving            students.removeIf(student -> !rollNumbers.add(student.getRollNo()));

            studentRepository.saveAll(students);
            return "Uploaded and saved " + students.size() + " unique students successfully!";
        } catch (Exception e) {
            throw new RuntimeException("Failed to store student data: " + e.getMessage());
        }
    }
}
