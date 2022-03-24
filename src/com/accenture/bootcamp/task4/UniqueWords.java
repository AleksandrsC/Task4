package com.accenture.bootcamp.task4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public class UniqueWords {

    /**
     *
     * @param text text to count words in "Words" are
     * @param isCaseSensitive true if need to ignore case
     * @param ignorePunctuation if true "one,", "one!" and "one" treated as the same word, as different if false.
     * @return number of unique words
     */
    public static int count(String text, boolean isCaseSensitive, boolean ignorePunctuation){
        if(isCaseSensitive) text=text.toUpperCase();
         String[] words=text.split(ignorePunctuation?"[\\s\\p{Punct}]+":"\\s+");
         HashSet<String> uniqueWords=new HashSet<>(Arrays.asList(words));
         return uniqueWords.size();

    }
}
