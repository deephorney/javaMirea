package org.example;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FileHashingApp {
    private String inputFileName;
    private String outputFileName;
    private MessageDigest digest;

    public FileHashingApp(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    @PostConstruct
    public void init() {
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hashInputFile();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private void hashInputFile() {
        try (InputStream inputStream = new FileInputStream(inputFileName);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            byte[] hash = digest.digest(outputStream.toByteArray());
            writeHashToFile(hash);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHashToFile(byte[] hash) {
        try (FileOutputStream outputStream = new FileOutputStream(outputFileName)) {
            outputStream.write(hash);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void cleanup() {
        File inputFile = new File(inputFileName);
        if (inputFile.exists()) {
            inputFile.delete();
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FileHashingApp <inputFileName> <outputFileName>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            try (FileWriter writer = new FileWriter(inputFileName)) {
                writer.write("null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileHashingApp fileHashingApp = new FileHashingApp(inputFileName, outputFileName);
    }
}
