package com.jknstudios.firescript.processor;


import com.jknstudios.firescript.FireScript;
import com.jknstudios.firescript.util.FrameUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.*;

public class CodeProcesser {
    public static void process(ArrayList<String> scriptContents) throws Exception {
        for (String sx : scriptContents) {
            if(sx.equals("nl():")) {
                System.out.println("");
            }
            if(sx.contains("prnt(\"")) {
                System.out.println(sx.replace("prnt(\"", "").replace("\"):", ""));
            }
            if(sx.contains("window(\"")) {
                FrameUtil.createFrame(sx.replace("window(\"", "").replace("\"):", ""), FireScript.fileName);
            }
            if(sx.equals("exit():")) {
                System.exit(0);
            }
            if(sx.contains("sysExec(\"")) {
                Runtime.getRuntime().exec(sx.replace("sysExec(\"", "").replace("\"):", ""));
            }
            if(sx.contains("Sys::mkFile(\"")) {
                File ff = new File(sx.replace("Sys::mkFile(\"", "").replace("\"):", ""));
                if(ff.exists()) {
                    System.out.println("firescript.error.file.FileError: File Already Exists \nError: " + sx);
                } else {
                    ff.createNewFile();
                }
            }
            if(sx.equals("Integer::randomInt()")) {
                int min = 0;
                int max = 32767;
                int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
                sx.replace("Integer::randomInt()", String.valueOf(random_int));
            }
            if(sx.contains("String::randomString(\"")) {
                int leftLimit = 48; 
                int rightLimit = 122; 
                int targetStringLength = Integer.valueOf(sx.replace("Steing::randomString(\"", "").replace("\"):", ""));
               // int targetStringLength = 10;
                Random random = new Random();
   
                String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
                sx.replace("String::randomString()", generatedString);
            }
        }
    }
}
