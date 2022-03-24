package com.accenture.bootcamp.task4;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FilesystemTest {
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
        return Collections.EMPTY_LIST;
    }


}