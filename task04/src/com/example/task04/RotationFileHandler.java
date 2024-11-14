package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler extends FileHandler implements MessageHandler{
    private ChronoUnit RotationUnit;
    private LocalDateTime LastRotation;
    private FileWriter Writer;

    public RotationFileHandler(String filePath) {
        super(filePath);
    }

    private void rotateFile() throws IOException {
        if (Writer != null) {
            Writer.close();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        String rotatedFilePath = FilePath + "_" + LastRotation.format(formatter);
        Writer = new FileWriter(rotatedFilePath, true);
    }
    @Override
    public void handleMessage(String message) {
        try {
            if (LocalDateTime.now().isAfter(LastRotation.plus(1, RotationUnit))) {
                LastRotation = LocalDateTime.now();
                rotateFile();
            }
            Writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}