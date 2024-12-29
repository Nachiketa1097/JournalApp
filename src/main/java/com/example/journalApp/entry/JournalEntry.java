package com.example.journalApp.entry;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journalEntry", collation = "{ 'locale': 'en', 'strength': 2 }")
@Data // This @Data contains @Getter and @Setter you can ctrl click to check all
public class JournalEntry {
    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;
}
