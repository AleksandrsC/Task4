package com.accenture.bootcamp.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FilesystemTest {
    private static final List<String> EMPTY_LIST=Collections.unmodifiableList(new ArrayList<>()) ;
    /**
     * w3r task:
     * Write a Java program to get a list of all file/directory names from the given.
     * @param path path
     * @return List$ltString$gt of files if a dir, empty list otherwise.
     */
    public static List<String> ls(String path){
        String[] list=new File(path).list();
        if(list!=null)
            return Arrays.asList(list);
        return EMPTY_LIST;
    }

    /**
     * 12. Write a Java program to read a plain text file.
     * @param path path to the file
     * @return File content as a single String or "cannot read file."
     */
    public static String readFile(String path) {
        File file=new File(path);
        FileInputStream fis;
        try{
            fis=new FileInputStream(file);
        }catch (Exception x){
            x.printStackTrace();//TODO: replace with proper logging
            return "cannot read file.";
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringBuilder rv=new StringBuilder();
            String current=br.readLine();
            while(current!=null){
                rv.append(current);
                rv.append(System.lineSeparator()); //TODO: figure out a way to keep the same line separator as original file.
                current=br.readLine();
            }
            return rv.toString();
        }catch (Exception x){
            x.printStackTrace();//TODO: replace with proper logging
            return "cannot read file.";
        }finally{
            try {
                fis.close();//shouldn't be null at this point.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
