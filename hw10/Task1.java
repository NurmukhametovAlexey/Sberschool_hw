package ru.sbrf.lesson13.hw10;

import java.io.*;
import java.nio.charset.Charset;

public class Task1 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Alex\\IdeaProjects\\HelloWorld\\src\\ru\\sbrf\\Lesson13\\hw10\\task1.txt";
        File file = new File(filePath);
        try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
            is.skip(2);
            String text = new String(is.readNBytes(4), Charset.defaultCharset());
            System.out.println(text);
        } catch (FileNotFoundException e) {
            System.err.println("No no file with path: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
        }
    }
}
