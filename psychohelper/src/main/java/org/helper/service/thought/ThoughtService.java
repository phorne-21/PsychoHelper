package org.helper.service.thought;

import org.helper.model.Thought;

import java.util.List;
import java.util.UUID;

public interface ThoughtService {

    List<Thought> createThought(Thought thought);

    List<Thought> getAll();

    Thought getById(UUID id);

    Thought update(UUID id, Thought thought);

    void deleteById(UUID id);
}
