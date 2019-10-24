package main;//package main.java.com.codecool.filePartReader;

import java.io.IOException;

public class Main {
        public static void main(String[] args) throws IOException {
            FilePartReader filePartReader = new FilePartReader();
            filePartReader.setup("/home/kuba/Pulpit/filepartreader-testing-with-junit-KubaL92/src/resources/test.txt", 1, 10);
            FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
            System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());
        }
    }

