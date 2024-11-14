package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private String Name;
    private Level currentLevel = Level.DEBUG;
    private static final Map<String, Logger> loggers = new HashMap<>();
    public enum Level {
        DEBUG(0),
        INFO(1),
        WARNING(2),
        ERROR(3);

        private final int priority;

        Level(int priority) {
            this.priority = priority;
        }
        public int getPriority() { return priority; }
    }
    Logger(String name){
        this.Name = name;
    }
    public void setName(String name){
        this.Name = name;
    }
    public String getName(){
        return this.Name;
    }
    public Level getLevel() {
        return currentLevel;
    }

    public void setLevel(Level level) {
        this.currentLevel = level;
    }
    public static Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, Logger::new);
    }
    public void log(Level lvl, String message)
    {
        if (lvl.getPriority() >= currentLevel.getPriority()) {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
            System.out.printf("[%s] %s %s - %s%n", lvl.name(), timestamp, Name, message);
        }
    }
    public void log(Level lvl, String message, Object... args) {
        log(lvl, String.format(message, args));
    }
    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void debug(String message, Object... args) {
        log(Level.DEBUG, message, args);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void info(String message, Object... args) {
        log(Level.INFO, message, args);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void warning(String message, Object... args) {
        log(Level.WARNING, message, args);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void error(String message, Object... args) {
        log(Level.ERROR, message, args);
    }
}
