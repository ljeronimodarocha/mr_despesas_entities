package org.mrdespesas.entities.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5074235630813004807L;

    @NotBlank
    private String title;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Expense> expenses;

    public void addExpense(Expense expense) {
        if (this.expenses == null) {
            this.expenses = new HashSet<>();
        }
        this.expenses.add(expense);
    }

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                ", owner=" + owner +
                '}';
    }
}
