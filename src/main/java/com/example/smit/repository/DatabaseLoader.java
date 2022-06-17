package com.example.smit.repository;

import com.example.smit.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final WordRepository repository;

    @Autowired
    public DatabaseLoader(WordRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        String pathToFile = "src/main/java/com/example/smit/repository/dictionary.txt";
        File inputFile = new File(pathToFile);

        try  {
            Scanner fileScanner = new Scanner(inputFile);
            while (fileScanner.hasNext()) {
                this.repository.save(new Word(fileScanner.nextLine().toLowerCase(Locale.ROOT)));
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
