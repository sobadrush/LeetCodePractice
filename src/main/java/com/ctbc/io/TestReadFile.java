package com.ctbc.io;

import java.io.*;

public class TestReadFile {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/frank/Desktop/aaa/test.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/frank/Desktop/aaa/output.txt", false));) {
            int lineNumber = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                if (lineNumber >= 2) {
                    // System.out.println(line);
                    String[] columns = line.split("\\s+");
                    // System.out.printf("%s %s %s %n", columns[1], columns[2], columns[3]);
                    bw.append(String.format("%s - %s - %s", columns[1], columns[2], columns[3]));
                    bw.newLine();
                }
                lineNumber++;
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
