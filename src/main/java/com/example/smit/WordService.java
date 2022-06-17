package com.example.smit;

import com.example.smit.domain.Word;
import com.example.smit.repository.WordRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

@Service
public class WordService {

    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word findWordById(Long id) {
        return wordRepository.findWordById(id);
    }

    public Word save(Word inputWord) {
        if (!wordRepository.existsWordByWordEquals(inputWord.getWord())) {
            return wordRepository.save(inputWord);
        } else {
            return new Word("word already in dictionary");
        }
    }

    public Word checkWord(String wordToCheck) {
        String inputWord = wordToCheck.toLowerCase(Locale.ROOT);
        Word answer = new Word(inputWord);

        if (wordRepository.existsWordByWordEquals(inputWord)) {
            answer.setExistInDictionary(true);
        } else {
            answer.setExistInDictionary(false);
        }

        answer.calculateScore();
        return answer;
    }
}
