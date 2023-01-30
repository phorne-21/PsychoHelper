package org.helper.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.helper.enums.Feeling;

import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Thought {
    private UUID id;

    @NotBlank(message = "Field 'thought' can't be empty.")
    private String thought;
    private Map<Feeling, Integer> feelings;
}
