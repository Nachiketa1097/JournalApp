package com.example.journalApp.entry;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "user", collation = "{ 'locale': 'en', 'strength': 2 }")
@Data
public class User {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @DBRef //This will connect my journalEntries with user
    private List<JournalEntry> journalEntries = new ArrayList<>();

    private List<String> roles; //part of spring boot security
}
