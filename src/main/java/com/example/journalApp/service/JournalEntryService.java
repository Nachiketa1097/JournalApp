package com.example.journalApp.service;

import com.example.journalApp.entry.JournalEntry;
import com.example.journalApp.entry.User;
import com.example.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry, String userName) {
        User user = userService.findByUserName(userName);
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userService.saveEntry(user);
    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) { // Optional may contains data or null
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id, String userName) {
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }
}