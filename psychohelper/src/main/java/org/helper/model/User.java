package org.helper.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.helper.enums.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
public class User {

    private UUID id;

    @Size(min = 2, max = 30, message = "Name can't contain less then 2 or more then 30 symbols.")
    @NotBlank(message = "User name can't be empty.")
    private String name;

    private Role role;

    private Map<UUID, Thought> thoughtMap;

    @NotNull(message = "User name can't be null.")
    @NotBlank(message = "email name can't be empty.")
    private String email;

    @NotNull(message = "User name can't be null.")
    @NotBlank(message = "User password can't be empty.")
    @Size(min = 6, max = 25)
    private String password;
}
