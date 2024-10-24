package com.example.Markdown.Note_taking.App.repository;

import com.example.Markdown.Note_taking.App.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
}
