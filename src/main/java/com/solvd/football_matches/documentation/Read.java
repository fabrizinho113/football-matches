package com.solvd.football_matches.documentation;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Read {

    private static final File DOCUMENT = new File("src\\main\\resources\\championsleague.txt");
    private static final File OUTPUT = new File("src\\main\\resources\\output_championsleague.txt");
    private static ArrayList<String> readOutput = new ArrayList<>();
    private static final Logger LOGGER = LogManager.getLogger(Read.class);

    public static void main(String[] args) {

        try {
            //Document to string
            String document = FileUtils.readFileToString(DOCUMENT, StandardCharsets.UTF_8);

            //Convert string to array of strings
            String[] arrayOfWords = StringUtils.split(document);


            //Test
            System.out.println(arrayOfWords.length);

            int j = 0;

            for (int i = 0; i < arrayOfWords.length; i++) {

                //Word from the array
                String word = arrayOfWords[i];

                //Count matches for word
                int ocurrences = StringUtils.countMatches(document, word);

                do {
                    //Add if there are no words in array
                    if (readOutput.isEmpty()) {
                        readOutput.add(arrayOfWords[i] + " - " + ocurrences);
                    }
                    //Logic to catch a word (make them all lowercase with StringUtils.lowerCase(word))
                    // If the word is the same ++ocurrences and add it into an arrayOfWords for readOutput
                    j++;



                }while (j < readOutput.size()) ;
            }
        }catch (IOException e){
            LOGGER.warn(e);
        }

        //Process done message
        LOGGER.info("Process completed");
    }



}
