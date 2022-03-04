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
        }
    }
}
