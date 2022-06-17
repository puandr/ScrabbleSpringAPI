package com.example.smit.repository;

import com.example.smit.domain.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
    Word findWordById(Long id);

    boolean existsWordByWordEquals(String word);

}
