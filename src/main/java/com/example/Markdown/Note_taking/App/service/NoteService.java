package com.example.Markdown.Note_taking.App.service;

import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final JLanguageTool languageTool;

    public NoteService() {
       languageTool = new JLanguageTool(new AmericanEnglish());    }

    public List<String> checkGrammar(String text) throws IOException {
        List<RuleMatch> matches = languageTool.check(text);
        List<String> suggestions = new ArrayList<>();

        for (RuleMatch match : matches) {
            String suggestion = "Error at line " + match.getLine() + ", column " + match.getColumn() + ": "
                    + match.getMessage();
            if (!match.getSuggestedReplacements().isEmpty()) {
                suggestion += ". Suggestion: " + match.getSuggestedReplacements();
            }
            suggestions.add(suggestion);
        }
        return suggestions;
    }
}
