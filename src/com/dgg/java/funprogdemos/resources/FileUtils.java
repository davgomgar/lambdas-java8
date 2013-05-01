package com.dgg.java.funprogdemos.resources;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: davgomgar
 */
public class FileUtils {

    private static InputStream stream;

    private FileUtils(String fileName) throws IOException {
        System.out.println("Creating a new stream to work with the file...");
        stream = new BufferedInputStream(new FileInputStream(new File(fileName)));
    }

    /**
     * This method mimics Ruby's File::open method. It allows you to open a file, pass a lambda expression and it
     * manages resources by itself, closing the stream when the work is done.
     *
     * @param fileName
     * @param resource
     * @throws java.io.IOException
     */
    public static void open(String fileName, IResourceInstance<InputStream, IOException> resource) throws IOException {
        FileUtils utils = new FileUtils(fileName);
        try {
            resource.apply(stream);
        } finally {
            utils.close();
        }

    }

    private void close() throws IOException {
        System.out.println("About to close the open stream....");
        stream.close();
    }

}
