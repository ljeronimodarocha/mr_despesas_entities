package org.mrdespesas.entities.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoResponse {

    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    @JsonIgnore
    private String token;

}
