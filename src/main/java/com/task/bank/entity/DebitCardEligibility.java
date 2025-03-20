package com.task.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="debit_card_eligibility")
public class DebitCardEligibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment for id
    private int id;

    @Column(name="card_type",nullable = false, length = 255)
    private String cardType;

    @Column(name="eligibility_criteria",nullable = false)
    private String eligibilityCriteria;
  

    // Optional: Override toString(), equals(), and hashCode() for better object handling.
    @Override
    public String toString() {
        return "DebitCardEligibility{" +
               "id=" + id +
               ", cardType='" + cardType + '\'' +
               ", eligibilityCriteria='" + eligibilityCriteria + '\'' +
               '}';
    }
}
