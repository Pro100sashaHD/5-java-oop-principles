package com.example.task04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    public String FilePath;

    public FileHandler(String filePath) {
        this.FilePath = filePath;
    }

    @Override
    public void handleMessage(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FilePath, true))) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
