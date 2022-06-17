package com.example.smit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmokeTest {
	@Autowired
	private WordController wordController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(wordController).isNotNull();
	}

}
