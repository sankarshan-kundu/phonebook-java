package com.java.sk.phonebook.service;

import com.java.sk.phonebook.dto.PhonebookDto;

import java.util.List;

public interface PhonebookService {
    PhonebookDto createPhonebookEntry(PhonebookDto phonebookDto);
    List<PhonebookDto> getPhonebook();
    PhonebookDto getPhonebookById(Long id);
    PhonebookDto updatePhonebook(Long id, PhonebookDto phonebookDto);
    void deletePhonebook(Long id);
}
