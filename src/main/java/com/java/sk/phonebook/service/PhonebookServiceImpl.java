package com.java.sk.phonebook.service;

import com.java.sk.phonebook.dto.PhonebookDto;
import com.java.sk.phonebook.entity.Phonebook;
import com.java.sk.phonebook.exception.PhonebookNotFoundException;
import com.java.sk.phonebook.mapper.PhonebookMapper;
import com.java.sk.phonebook.repository.PhonebookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhonebookServiceImpl implements PhonebookService {

    private PhonebookRepository phonebookRepository;

    @Override
    public PhonebookDto createPhonebookEntry(PhonebookDto phonebookDto) {
        Phonebook phonebook = PhonebookMapper.mapToPhonebook(phonebookDto);
        Phonebook savedPhonebookEntry = phonebookRepository.save(phonebook);
        return PhonebookMapper.mapToPhonebookDto(savedPhonebookEntry);
    }

    @Override
    public List<PhonebookDto> getPhonebook() {
        return phonebookRepository.findAll().stream().map(PhonebookMapper::mapToPhonebookDto).toList();
    }

    @Override
    public PhonebookDto getPhonebookById(Long id) {
        Phonebook phonebookEntry = phonebookRepository.findById(id)
                .orElseThrow(() -> new PhonebookNotFoundException("ID " + id + " not found!"));

        return PhonebookMapper.mapToPhonebookDto(phonebookEntry);
    }

    @Override
    public PhonebookDto updatePhonebook(Long id, PhonebookDto phonebookDto) {
        Phonebook phonebookEntry = phonebookRepository.findById(id)
                .orElseThrow(() -> new PhonebookNotFoundException("ID " + id + " not found!"));
        phonebookEntry.setFirstName(phonebookDto.getFirstName());
        phonebookEntry.setLastName(phonebookDto.getLastName());
        phonebookEntry.setPhoneNumber(phonebookDto.getPhoneNumber());
        Phonebook savedPhonebookEntry = phonebookRepository.save(phonebookEntry);
        return PhonebookMapper.mapToPhonebookDto(savedPhonebookEntry);
    }

    @Override
    public void deletePhonebook(Long id) {
        Phonebook phonebookEntry = phonebookRepository.findById(id)
                .orElseThrow(() -> new PhonebookNotFoundException("ID " + id + " not found!"));
        phonebookRepository.delete(phonebookEntry);
    }
}
