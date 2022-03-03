package com.jknstudios.firescript.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.*;

public class FileProcesser {
    public static ArrayList<String> readFile(String filename) throws IOException {
        Scanner s = null;
        try {
            s = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();

        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(new File(filename).toPath(), Charset.defaultCharset() );
        return lines;
    }
}
