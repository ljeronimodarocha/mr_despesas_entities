package org.mrdespesas.entities.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 8558444651398542544L;

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;

    private String categoryId;

    private String projectId;
}
