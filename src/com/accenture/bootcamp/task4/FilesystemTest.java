package com.accenture.bootcamp.task4;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

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
     * @deprecated  it's clunky old-style code try with resources should be used for all modern applications
     * as well as java.util.scanner if you don't need thread safety.
     */
    public static String readFile(String path) {
        File file=new File(path);
        FileInputStream fis;
        try{
            fis=new FileInputStream(file);
        }catch (Exception x){
            x.printStackTrace();
            return "cannot read file.";
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringBuilder rv=new StringBuilder();
            String current=br.readLine();
            while(current!=null){
                rv.append(current);
                rv.append(System.lineSeparator());
                current=br.readLine();
            }
            return rv.toString();
        }catch (Exception x){
            x.printStackTrace();
            return "cannot read file.";
        }finally{
            try {
                fis.close();//shouldn't be null at this point.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }//readFile

    /**
     * 12. Write a Java program to read a plain text file.
     * A better implementation.
     * @param path path to the file
     * @return File content as a single String or "cannot read file."
     */
    public static String readFileWithScanner(String path) {
        StringBuilder rv;
        try (Scanner s = new Scanner(Path.of(path))) {
            s.useDelimiter("\\n");
            rv = new StringBuilder();
            while (s.hasNext()) {
                rv.append(s.next());
                rv.append("\n");//Scanner should return us \r if the file has \r\n
            }
        }catch(Exception x){
            //x.printStackTrace();
            return "cannot read file.";
        }
        return rv.toString();
    }

    /**
     * W3r task:
     * 18. Write a Java program to find the longest word in a text file.
     * @param path path to file
     * @return the longest word or empty string if it cannot read file, or it has no words/tokens
     * as per "[\\s\\p{Punct}]+" as java.util.Scanner delimiter.
     */
    public static String longestWord(String path){
        String rv="";
        try (Scanner s = new Scanner(Path.of(path))) {
            s.useDelimiter("[\\s\\p{Punct}]+");
            while(s.hasNext()){
                String newWord=s.next();
                if(rv.length()<newWord.length())
                    rv=newWord;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rv;

    }

    /**
     * W3r task 16
     * 16. Write a Java program to append text to an existing file.
     * @param path path to file
     * @param data data to be appended
     */
    public static void appendStringToFile (String path, String data){
        try(OutputStreamWriter out=new OutputStreamWriter (new BufferedOutputStream(new FileOutputStream(path,true)))){
            out.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//appendStringToFile
    /**
     * W3r task helper method, so we would always have the same file.
     * @param path path to file
     * @param data data to be stored
     */
    public static void initFile (String path, String data){
        try(OutputStreamWriter out=new OutputStreamWriter (new BufferedOutputStream(new FileOutputStream(path,false)))){
            out.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//appendStringToFile

}
