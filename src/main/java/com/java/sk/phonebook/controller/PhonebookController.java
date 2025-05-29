package com.java.sk.phonebook.controller;

import com.java.sk.phonebook.dto.PhonebookDto;
import com.java.sk.phonebook.service.PhonebookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phonebook")
@AllArgsConstructor
public class PhonebookController {
    private PhonebookService phonebookService;

    @PostMapping
    public ResponseEntity<PhonebookDto> createPhonebookEntry(@RequestBody PhonebookDto phonebookDto) {
        PhonebookDto savedPhonebookEntry = phonebookService.createPhonebookEntry(phonebookDto);
        return new ResponseEntity<>(savedPhonebookEntry, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PhonebookDto>> getAllPhonebookEntries() {
        return ResponseEntity.ok(phonebookService.getPhonebook());
    }

    @GetMapping("{id}")
    public ResponseEntity<PhonebookDto> getPhonebookById(@PathVariable("id") Long phonebookId) {
        return ResponseEntity.ok(phonebookService.getPhonebookById(phonebookId));
    }

    @PutMapping("{id}")
    public ResponseEntity<PhonebookDto> updatePhonebook(@PathVariable("id") Long phonebookId, @RequestBody PhonebookDto phonebookDto) {
        return ResponseEntity.ok(phonebookService.updatePhonebook(phonebookId, phonebookDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePhonebookEntry(@PathVariable("id") Long phonebookId){
        phonebookService.deletePhonebook(phonebookId);
        return ResponseEntity.noContent().build();
    }
}
