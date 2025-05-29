package com.java.sk.phonebook.mapper;

import com.java.sk.phonebook.dto.PhonebookDto;
import com.java.sk.phonebook.entity.Phonebook;

public class PhonebookMapper {
    public static PhonebookDto mapToPhonebookDto(Phonebook phonebook) {
        return new PhonebookDto(
                phonebook.getId(),
                phonebook.getFirstName(),
                phonebook.getLastName(),
                phonebook.getPhoneNumber());
    }

    public static Phonebook mapToPhonebook(PhonebookDto phonebookDto) {
        return new Phonebook(
                phonebookDto.getId(),
                phonebookDto.getFirstName(),
                phonebookDto.getLastName(),
                phonebookDto.getPhoneNumber()
        );
    }
}
