package com.dgg.java.funprogdemos.resources;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: davgomgar
 */
public class FileUtilsDemo {

    public static void main(String[] args) throws IOException {
        System.out.println("Print file content");
        FileUtils.open("/etc/passwd", FileUtilsDemo::printStreamContent);
        System.out.println("And now, count file lines...");
        FileUtils.open("/etc/passwd",
                stream -> {
                    System.out.println(String.format("There are %d lines in the file", calculateLines(stream)));
                });
    }

    private static void printStreamContent(InputStream stream) throws IOException {
        int c;
        while ((c = stream.read()) != -1) {
            System.out.print((char) c);
        }

    }

    private static Integer calculateLines(InputStream stream) throws IOException {
        Integer lines = 0;
        int c;
        while ((c = stream.read()) != -1) {
            if (c == '\n') lines++;
        }
        return lines;
    }
}
