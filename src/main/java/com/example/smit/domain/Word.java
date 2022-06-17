package com.example.smit.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Word {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  Long id;
    private String word;
    boolean existInDictionary;
    private int score;

    public Word (String word) {
        this.word = word;
    }

    public Word (String word, int score) {
        this.word = word;
        this.score = score;
    }



    //TODO make game rules standalone
    public void calculateScore() {
        int wordScore = 0;

        for (char letter : this.word.toCharArray()) {
            wordScore = wordScore + getSingleLetterPoints(letter);
        }

        this.setScore(wordScore);
    }

    public boolean isExistInDictionary() {
        return existInDictionary;
    }

    public void setExistInDictionary(boolean existInDictionary) {
        this.existInDictionary = existInDictionary;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private static List<Character> convertStringToListOfChars(String input) {
        List<Character> output = new ArrayList<>();
        for (char singleChar : input.toCharArray()) {
            output.add(singleChar);
        }
        return output;
    }

    private int getSingleLetterPoints(char letter) {
        List<LetterPoints> allLetterPoints;

        allLetterPoints = Arrays.asList(
                new LetterPoints(1, convertStringToListOfChars("eaionrtlsu")),
                new LetterPoints(2, convertStringToListOfChars("dg")),
                new LetterPoints(3, convertStringToListOfChars("bcmp")),
                new LetterPoints(4, convertStringToListOfChars("fhvwy")),
                new LetterPoints(5, convertStringToListOfChars("k")),
                new LetterPoints(8, convertStringToListOfChars("jx")),
                new LetterPoints(10, convertStringToListOfChars("qz"))
        );

        for (LetterPoints hopper : allLetterPoints) {
            if (hopper.containsLetter(letter)) {
                return hopper.getScore();
            }
        }
        return 0;
    }
}

class LetterPoints {
    private final int points;
    private final List<Character> letters;

    public LetterPoints(int point, List<Character> letters) {
        this.points = point;
        this.letters = new ArrayList<Character>(letters);
    }

    public int getScore() {
        return points;
    }

    public boolean containsLetter(Character letter) {
        return letters.contains(letter);
    }

}
