package org.helper.service.thought;

import lombok.RequiredArgsConstructor;
import org.helper.exceptions.ThoughtNotFoundException;
import org.helper.model.Thought;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ThoughtServiceImpl implements ThoughtService{

    private final Map<UUID, Thought> thoughtMap = new HashMap<>();

    @PostConstruct
    private void  init() {
        Thought thought = new Thought();
        thought.setId(UUID.randomUUID());
        thought.setThought("I'm so sad.");
        thought.setFeelings(new HashMap<>());
        thoughtMap.put(thought.getId(), thought);
        Thought thought2 = new Thought();
        thought2.setId(UUID.fromString("5c7fb22b-d0ee-4e06-9b1d-6a1f5fa4493d"));
        thought2.setThought("I'm so glad.");
        thought2.setFeelings(new HashMap<>());
        thoughtMap.put(thought2.getId(), thought2);
    }

    @Override
    public List<Thought> createThought(Thought thought) {
        thought.setId(UUID.randomUUID());
        thought.setFeelings(new HashMap<>());
        thoughtMap.put(thought.getId(), thought);
        return new ArrayList<>(thoughtMap.values());
    }

    @Override
    public Thought update(UUID id, Thought thought) {
        if (!thoughtMap.containsKey(id)) {
            throw new ThoughtNotFoundException("Thought with id " + " doesn't exist. Create new.");
        }
        thought.setId(id);
        thoughtMap.put(id, thought);
        return thoughtMap.get(id);
    }

    @Override
    public List<Thought> getAll() {
        return new ArrayList<>(thoughtMap.values());
    }

    @Override
    public Thought getById(UUID id) {
        if (!thoughtMap.containsKey(id)) {
            throw new ThoughtNotFoundException("Can't get thought by id " + " cause it doesn't exist.");
        }
        return thoughtMap.get(id);
    }

    @Override
    public void deleteById(UUID id) {
        if (thoughtMap.containsKey(id))
            thoughtMap.remove(id);
        else
            throw new ThoughtNotFoundException("Can't delete Thought with id " + id + " cause it doesn't exist.");
    }
}
