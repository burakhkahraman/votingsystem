package com.heroes.votingsystem.service.impl;

import com.heroes.votingsystem.model.Option;
import com.heroes.votingsystem.repository.OptionRepository;
import com.heroes.votingsystem.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    private final OptionRepository optionRepository;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public Option createOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    @Override
    public Option getOptionById(Long id) {
        return optionRepository.findById(id).orElse(null);
    }

    @Override
    public Option updateOption(Long id, Option option) {
        Option existingOption = optionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid option ID: " + id));


        existingOption.setValue(option.getValue());

        return optionRepository.save(existingOption);
    }

    @Override
    public void deleteOption(Long id) {
        optionRepository.deleteById(id);
    }
}
