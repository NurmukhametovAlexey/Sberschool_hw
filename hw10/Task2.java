package ru.sbrf.lesson13.hw10;

import java.io.*;
import java.nio.charset.Charset;


public class Task2 {
    public static void main(String[] args) {
        File dir = new File(System.getProperty("user.dir") + "/src/ru/sbrf/Lesson13/hw10");
        File file = new File(dir, "task2.txt");

        try {
            file.createNewFile();

            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file))) {
                stream.write("Люблю Java!".getBytes(Charset.defaultCharset()));
            } catch (FileNotFoundException e) {
                System.err.println("No such file: " + file.getPath());
            }

        } catch (IOException e) {
            System.err.println("Error working with file: " + file.getPath());;
        }

        System.out.println("Successfully written to " + file.getPath());
    }
}
