package com.java.master.file;


import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author wangqing 
 */
public class FileTest {

    public static void main(String[] args) throws IOException {

        String path = "/Users/wangqing/Documents/github/java-master/java-master/src/main/java/com/java/master/file/file1";
        byte[] bytes = Files.toByteArray(new File(path));
        System.out.println(new String(bytes, Charset.forName("utf-8")));
    }

}
