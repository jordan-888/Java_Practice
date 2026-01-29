package datastructures.linearandbinarysearch;
/**
 * Linear Search Problem 2: Search for a Specific Word in a List of Sentences
 * 
 * Problem:
 * You are given an array of sentences (strings). Write a program that performs
 * Linear Search to find the first sentence containing a specific word.
 * If the word is found, return the sentence. If no sentence contains the word,
 * return "Not Found".
 * 
 * Approach:
 * 1. Iterate through the list of sentences
 * 2. For each sentence, check if it contains the specific word
 * 3. If the word is found, return the current sentence
 * 4. If no sentence contains the word, return "Not Found"
 */
public class SearchWordInSentences {

    public static String findSentenceWithWord(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Search for Specific Word in Sentences (Linear Search) ===\n");

        String[] sentences = {
                "Java is a powerful programming language",
                "Python is great for data science",
                "JavaScript runs in the browser",
                "C++ is used for system programming",
                "Ruby on Rails is a web framework",
                "Go is designed for concurrent programming",
                "Rust provides memory safety without garbage collection"
        };

        String[] wordsToSearch = { "Java", "data", "mobile", "framework", "memory", "PHP" };

        System.out.println("Sentences:");
        for (int i = 0; i < sentences.length; i++) {
            System.out.printf("%d. %s%n", i + 1, sentences[i]);
        }
        System.out.println();

        System.out.println("Search Results:");
        System.out.println("=".repeat(50));
        for (String word : wordsToSearch) {
            String result = findSentenceWithWord(sentences, word);
            System.out.printf("Searching for '%s':%n  Result: %s%n%n", word, result);
        }
    }
}
