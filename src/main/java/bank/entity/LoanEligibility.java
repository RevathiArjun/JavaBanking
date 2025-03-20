package bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanEligibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private int id;

    @Column(nullable = false)  // Ensures loan_type cannot be null
    private String loanType;

    @Column(nullable = false)  // Ensures eligibility_criteria cannot be null
    private String eligibilityCriteria;

    // Override toString for easy printing
    @Override
    public String toString() {
        return "LoanEligibility{" +
                "id=" + id +
                ", loanType='" + loanType + '\'' +
                ", eligibilityCriteria='" + eligibilityCriteria + '\'' +
                '}';
    }
}
