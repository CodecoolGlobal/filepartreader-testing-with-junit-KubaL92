package main;//package main.java.com.codecool.filePartReader;

import main.FilePartReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {

    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    private List<String> split() throws IOException {
        String originalText = filePartReader.readLines().replaceAll("[.]*[,]*\\n*", "");
        return Arrays.asList(originalText.split("\\W"));
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> splittedText = split();
        splittedText.sort(String::compareToIgnoreCase);
        return splittedText;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        List<String> wordsContainingSubstring = new ArrayList<>();
        List<String> splittedText = split();

        for (String word : splittedText) {
            if (word.contains(subString)) {
                wordsContainingSubstring.add(word);
            }
        }
        return wordsContainingSubstring;
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        List<String> palindromes = new ArrayList<>();
        List<String> splittedText = split();

        for (String word : splittedText) {
            if (word.length() > 1 && word.equals(reverse(word))) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    private String reverse(String word) {
        StringBuilder input = new StringBuilder();
        input.append(word);
        input = input.reverse();
        return input.toString();
    }
}

