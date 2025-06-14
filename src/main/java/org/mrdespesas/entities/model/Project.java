package org.mrdespesas.entities.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "project")
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Project extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -410563911341732882L;

    @NotBlank
    private String title;

    @ManyToOne
    private User owner;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Expense> expenses;

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", owner=" + owner +
                '}';
    }
}