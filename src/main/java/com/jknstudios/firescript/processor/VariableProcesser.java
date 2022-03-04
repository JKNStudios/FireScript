package com.jknstudios.firescript.processor;

import com.jknstudios.firescript.FireScript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.*;

public class VariableProcesser {
  public static Map<String, String> variableMap = new HashMap<>();
  private static int i;
  
  public static void process(ArrayList<String> scriptContents) throws Exception {
        for (String sx : scriptContents) {
          if(sx.contains("Variable::new(\"") {
            if(sx.contains("::val(\"")) {
              String[] var_infoarray = sx.split("::");
              // Variable Format:
              // Variable::new(varname)::val("Hello, World"):
              List<String> list = new ArrayList<String>(Arrays.asList(var_infoarray));
              list.remove("Variable");
          
              list.set(1, list.get(1).replace("new(\"", "").replace("\")", ""));
              list.set(2, list.get(2).replace("val(\")", "").replace("\"):", "");
            } else {
              sx.replace("Variable::new(\"", "");
            }
          }
        }
}
