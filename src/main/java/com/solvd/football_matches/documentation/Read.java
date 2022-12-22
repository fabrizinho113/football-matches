package com.solvd.football_matches.documentation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Read {
    private static final Logger LOGGER = LogManager.getLogger(Read.class);

    public static void main(String[] args) {

        String text = "";
        try {
            text = FileUtils.readFileToString(new File("src\\main\\resources\\championsleague.txt"), "UTF-8");
        } catch (IOException e) {
            LOGGER.error(e);
        }

        //Remove . , ""
        text = StringUtils.replaceChars(text,',',' ');
        text = StringUtils.replaceChars(text,'.',' ');
        text = StringUtils.replaceChars(text, '"',' ');

        //Creating array to store words without spaces
        String[] words = StringUtils.split(text, " ");


        //Creating HashSet to store unique words
        HashSet<String> unique = new HashSet<>();
        //Creating HashMap to store: word (String) and the amount of times it is repeated (Integer)
        HashMap<String, Integer> occurrences = new HashMap<>();

        for (String word : words) {
            unique.add(word);
            if (occurrences.containsKey(word)) {
                occurrences.put(word, occurrences.get(word) + 1);
            } else {
                occurrences.put(word, 1);
            }
        }
        //Log the amount of unique words from unique HashSet
        LOGGER.info("Number of unique words: " + unique.size());

        //Create the output file with try with resources
        try (FileWriter wordCounter = new FileWriter("src\\main\\resources\\output_championsleague.txt")){
            for(String word: occurrences.keySet()){
                wordCounter.write(word + " - " + occurrences.get(word) + "\n");
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }

        LOGGER.info("Process completed");


    }
}
