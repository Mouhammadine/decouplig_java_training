package fr.lernejo.logger;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
    String callerClass;
    Logger delegateLogger;


    public ContextualLogger(String callerClass,Logger delegateLogger) {
        this.delegateLogger = delegateLogger;
        this.callerClass = callerClass;
    }

    @Override
    public void log(String message)
    {
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        delegateLogger.log(LocalDateTime.now().format(formatter) + " " + callerClass + " " + message);
    }
}
