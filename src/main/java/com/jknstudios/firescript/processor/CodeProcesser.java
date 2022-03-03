package com.jknstudios.firescript.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.*;

public class CodeProcesser {
    public static void executeScript(ArrayList<String> scriptContents) {
        for (String sx : scriptContents) {
            if(sx.equals("nl():")) {
                System.out.println("\n");
            }
            if(sx.contains("prnt(")) {
                System.out.println(sx.replace("prnt(", "").replace("):", ""));
            }
         }
    }
}
