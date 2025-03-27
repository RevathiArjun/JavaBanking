package com.task.bank.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "students") 
@Getter @Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Student {

    @Id@Column(unique = true, nullable = false)private String rollNo;

    private String name;
}
