package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.*;

public class Logger {
    private String Name;
    private Level currentLevel = Level.DEBUG;
    private static final Map<String, Logger> loggers = new HashMap<>();
    MessageHandler handler;
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
    public void SetHandler(MessageHandler handler){
        this.handler = handler;
    }
    public void log(MessageHandler handler, Level lvl, String message)
    {
        if (lvl.getPriority() >= currentLevel.getPriority()) {
            handler.handleMessage(message);
        }
    }
}
