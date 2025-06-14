package org.mrdespesas.entities.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "expense")
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Expense extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6294339922921123736L;

    private String description;

    private BigDecimal price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "expense_category",
            joinColumns = @JoinColumn(name = "expense_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    public void addProject(Project project) {
        this.project = project;
    }

    public void addCategory(Category category) {
        if (category == null) return;
        category.addExpense(this);
        if (this.categories == null) {
            this.categories = new HashSet<>();
        }
        this.categories.add(category);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", owner=" + owner +
                ", project=" + project +
                '}';
    }
}
