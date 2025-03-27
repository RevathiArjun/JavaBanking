package com.task.bank.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.task.bank.service.StudentService;


@RestController @RequestMapping("/api/students") public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/upload")public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = studentService.saveStudentsFromExcel(file);
        return ResponseEntity.ok(message);
    }
}
