package com.example.Markdown.Note_taking.App.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "note")
public class Note {
    @Id
    private Long id;

    private String title;
    private String content;
}
