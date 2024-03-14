package ua.ukma.kucherenko.files;

import java.io.*;

public class WorkWithFiles {
    public static void main(String[] args) {
        final String IN_FILE_NAME = "src/ua/ukma/kucherenko/files/test";
        final String OUT_FILE_NAME = "src/ua/ukma/kucherenko/files/outp";

        try (BufferedReader br = new BufferedReader(new FileReader(IN_FILE_NAME));
             PrintWriter pw = new PrintWriter(OUT_FILE_NAME)) {
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
                pw.println(st);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

