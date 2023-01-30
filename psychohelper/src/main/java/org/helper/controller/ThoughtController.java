package org.helper.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.helper.model.Thought;
import org.helper.service.thought.ThoughtService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/thoughts/")
@Slf4j
public class ThoughtController {

    private final ThoughtService thoughtService;

    @PostMapping()
    public List<Thought> create(@Valid @RequestBody Thought thought) {
        log.info("Create thought.");
        return thoughtService.createThought(thought);
    }

    @GetMapping()
    public List<Thought> getAll() {
        log.info("Get all thoughts.");
        return thoughtService.getAll();
    }

    @GetMapping("{id}")
    public Thought getThoughtById(@PathVariable UUID id) {
        log.info("Get thought by id.");
        return thoughtService.getById(id);
    }

    @PatchMapping("{id}")
    public Thought update(@Valid @RequestBody Thought thought, @PathVariable UUID id) {
        log.info("Update thought.");
        return thoughtService.update(id, thought);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable UUID id) {
        log.info("Delete thought.");
        thoughtService.deleteById(id);
    }
}
