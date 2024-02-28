package com.heroes.votingsystem.controller;

import com.heroes.votingsystem.model.Option;
import com.heroes.votingsystem.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
public class OptionController {
    private final OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @PostMapping
    public Option createOption(@RequestBody Option option) {
        return optionService.createOption(option);
    }

    @GetMapping("/{id}")
    public Option getOptionById(@PathVariable Long id) {
        return optionService.getOptionById(id);
    }

    @GetMapping
    public List<Option> getAllOptions() {
        return optionService.getAllOptions();
    }

    @PutMapping("/{id}")
    public Option updateOption(@PathVariable Long id, @RequestBody Option option) {
        return optionService.updateOption(id, option);
    }

    @DeleteMapping("/{id}")
    public void deleteOption(@PathVariable Long id) {
        optionService.deleteOption(id);
    }
}