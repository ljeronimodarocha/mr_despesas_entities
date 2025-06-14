package org.mrdespesas.entities.dto.response;

import lombok.*;
import org.mrdespesas.entities.model.BaseEntity;
import org.mrdespesas.entities.model.Expense;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExpenseResponse {

    private String id;

    private String description;

    private BigDecimal price;

    private Long wonerId;

    private String projectId;

    private Set<String> categoriesId;

    public ExpenseResponse(Expense expense) {
        this.id = expense.getPublicId();
        this.description = expense.getDescription();
        this.price = expense.getPrice();
        this.wonerId = expense.getOwner().getId();
        this.projectId = expense.getProject() != null ? expense.getProject().getPublicId() : null;
        this.categoriesId = expense.getCategories() != null ? expense.getCategories().stream()
                .map(BaseEntity::getPublicId)
                .collect(Collectors.toSet()) : null;
    }
}
