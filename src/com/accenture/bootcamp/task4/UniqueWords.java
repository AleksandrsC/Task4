package com.accenture.bootcamp.task4;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public class UniqueWords {

    /**
     *
     * @param text text to count words in "Words" are
     * @param isCaseSensitive true if need to ignore case
     * @return number of unique words
     */
    public static int count(String text, boolean isCaseSensitive){
         String[] words=text.split("\\s+");
         HashSet<String> uniqueWords=new HashSet<>(words.length);
         for(String word:words){
             if(isCaseSensitive) word=word.toUpperCase();
             uniqueWords.add(word);
         }
         return uniqueWords.size();

    }
}
