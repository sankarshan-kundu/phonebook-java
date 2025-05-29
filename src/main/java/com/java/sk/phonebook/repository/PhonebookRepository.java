package com.java.sk.phonebook.repository;

import com.java.sk.phonebook.entity.Phonebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonebookRepository extends JpaRepository<Phonebook, Long> {
}
