package com.example.smit;

import com.example.smit.domain.Word;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class WordController {
    @Autowired
    WordService wordService;

    @PostMapping("/api/word")
    public Word save(@RequestParam String word) {
        Word wordCreate = wordService.save(new Word(word));
        return wordCreate;
    }

    @GetMapping("/api/word/score/{word}")
    public Word checkWord(@PathVariable String word) {
        return wordService.checkWord(word);
    }
}