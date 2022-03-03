package com.jknstudios.firescript;

import com.jknstudios.firescript.processor.FileProcesser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FireScript {
    public static boolean debugData = false;
    public static HashMap<String, String> vars = new HashMap<>();

    public static void main(String args[]) throws IOException {
        if(args[0].toLowerCase().contains("-r") || args[0].toLowerCase().contains("--run")) {
            if (new File(args[1]).exists()) {
                if(debugData) {
                System.out.println("----------------------------{[ DEBUG INFORMATION ]}----------------------------");
                for(int i = 0; i<args.length; i++) {
                    System.out.println("args[" + i + "]: " + args[i]);
                }
                System.out.println(FileProcesser.readFile(args[1]));
                }
                ArrayList<String> scriptContents = FileProcesser.readFile(args[1]);
                if(scriptContents.get(0).equalsIgnoreCase("def firescript.script.FireApp:")) {
                    scriptContents.remove(0);
                    for (String sx : scriptContents) {
                        if(sx.contains("vrb")) {
                            String varx = 
                        }
                        if(sx.contains("prnt(")) {
                            System.out.println(sx.replace("prnt(", "").replace("):", ""));
                        }
                    }
                } else {
                    System.out.println("FireScript: Invalid Script!");
                }
            } else {
                System.out.println("FireScript: File Does Not Exist!");
            }
        } else {
            System.out.println("Usage: firescript -r [file]");
        }
    }
}
