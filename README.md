# Description
It's a simple Scarbble game emulation. There is a small dictionary with "legal" words. After sending a word you get an answer with a score for this word and an indication if this word is in the dictionary or not. You can also add new words to the dictionary.

Database is memory based, so no dictionary updates are saved after restarting the application.

# Usage

After launching main application you can make HTTP requests to http://localhost:8080

- GET /api/words - browses a current collection of words in dictionary
- GET /api/word/score/sampleword - where sampleword is a custom word you would like to check and calculate its score
- POST api/word?word=sampleword - the way you add new word to dictionary
