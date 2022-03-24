package com.accenture.bootcamp.task4;


public class Main {

    public static void main(String[] args) {
        ColourFun.ColourDemo();

        String test1 = "one two one, one";
        System.out.println("Test case 1:"+test1 );
        System.out.printf("w/o punctuation ignored count should be 3: %d%n", UniqueWords.count(test1,false,false));
        System.out.printf("with punctuation ignored it should be 2: %d%n", UniqueWords.count(test1,false,true));
        String test2 = "One two one one";

        System.out.println("Test case 2:"+test2 );
        System.out.printf("case sensitive count should be 3: %d%n", UniqueWords.count(test1,true,true));
        System.out.printf("case insensitive  should be 2: %d%n", UniqueWords.count(test1,false,true));

        System.out.println("Test case 3: Text.TEXT" );
        System.out.println("note interesting way the word 'IS-A' is handled" );
        System.out.printf("case sensitive punct ignored: %d%n", UniqueWords.count(Text.TEXT,true,true));
        System.out.printf("case sensitive punct kept: %d%n", UniqueWords.count(Text.TEXT,true,false));
        System.out.printf("case insensitive punct ignored: %d%n", UniqueWords.count(Text.TEXT,false,true));
        System.out.printf("case insensitive punct kept: %d%n", UniqueWords.count(Text.TEXT,false,false));

    }
}
