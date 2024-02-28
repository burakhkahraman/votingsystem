package com.heroes.votingsystem.service;

import com.heroes.votingsystem.model.Option;

import java.util.List;

public interface OptionService {
    Option createOption(Option option);
    List<Option> getAllOptions();
    Option getOptionById(Long id);
    Option updateOption(Long id, Option option); // Ekledik
    void deleteOption(Long id);
}
