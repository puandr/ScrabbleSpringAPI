package com.example.smit;

import com.example.smit.repository.WordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SmitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmitApplication.class, args);
	}

	@Component
	public class Runner implements CommandLineRunner {
		private final WordRepository repository;

		public Runner(WordRepository repository) {
			this.repository = repository;
		}


		@Override
		public void run(String... args) throws Exception {

		}
	}
}
