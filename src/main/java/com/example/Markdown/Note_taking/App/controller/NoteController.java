package com.example.Markdown.Note_taking.App.controller;

import com.example.Markdown.Note_taking.App.entity.Note;
import com.example.Markdown.Note_taking.App.repository.NoteRepository;
import com.example.Markdown.Note_taking.App.service.NoteService;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private final NoteRepository noteRepository;

    @Autowired
    private final NoteService noteService;

    public NoteController(NoteRepository noteRepository, NoteService noteService) {
        this.noteRepository = noteRepository;
        this.noteService = noteService;
    }


    @PostMapping("/upload")
    public ResponseEntity<String> uploadNoteFile(@RequestParam("file") MultipartFile file) throws IOException{
        String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        Path filePath = Paths.get("uploads/", fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());
        return ResponseEntity.ok("File uploaded successfully: " + filePath.toString());
    }

    @PostMapping("/save")
    public ResponseEntity<Note> saveNote(@RequestBody Note note) {
        Note savedNote = noteRepository.save(note);
        return ResponseEntity.ok(savedNote);
    }

    @PostMapping("/render")
    public ResponseEntity<String> renderMarkdown(@RequestParam String markdownContent) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdownContent);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String htmlContent = renderer.render(document);
        return ResponseEntity.ok(htmlContent);
    }

    @PostMapping("/check-grammar")
    public ResponseEntity<List<String>> checkGrammar(@RequestParam String text) throws IOException {
        return ResponseEntity.ok(noteService.checkGrammar(text));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable String id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
