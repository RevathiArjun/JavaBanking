package com.task.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.bank.entity.Student;
public interface StudentRepository extends JpaRepository<Student, String> {
}
