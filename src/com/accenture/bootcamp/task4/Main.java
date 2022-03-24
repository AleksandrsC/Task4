package com.accenture.bootcamp.task4;


import java.io.File;

public class Main {

    public static void main(String[] args) {
        ColourFun.ColourDemo();

        System.out.println();
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
        System.out.println();
        System.out.println("w3 resources tasks");
        System.out.println("list working dir:"+FilesystemTest.ls(System.getProperty("user.dir")));
        String testfile=System.getProperty("user.dir")+"/ExerciseDataFiles/text.txt";
        System.out.println("file "+testfile+" contents:");
        System.out.println(FilesystemTest.readFile(testfile));
        System.out.println("file "+testfile+" contents using more modern Java:");
        System.out.println(FilesystemTest.readFileWithScanner(testfile));
        System.out.println("nonexistent file using more modern Java:");
        System.out.println(FilesystemTest.readFileWithScanner("there's no such file"));
        System.out.println();
        System.out.println("Longest word demo");
        System.out.println("The longest word in "+testfile+" is:"+FilesystemTest.longestWord(testfile));
        System.out.println();
        System.out.println("File output demo");
        String testfileV=System.getProperty("user.dir")+"/ExerciseDataFiles/volatile.txt";
        FilesystemTest.initFile(testfileV,"Hello, world!\n");
        System.out.println("File created, initial content");
        System.out.println(FilesystemTest.readFile(testfileV));
        FilesystemTest.appendStringToFile(testfileV,"Try with resources is great, use it.");
        System.out.println("new content");
        System.out.println(FilesystemTest.readFile(testfileV));
        if(new File(testfileV).delete()){
            System.out.println("file deleted|");
        }else{
            System.out.println("file disappeared?");
        }


    }
}
