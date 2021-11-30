package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    private final Logger logger;
    private final String name;
    private final DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;

    public ContextualLogger(Logger logger, String name) {
        this.logger = logger;
        this.name = name;
    }

    @Override
    public void log(String message) {
        this.logger.log(String.format("[%s][%-10s] %s", ZonedDateTime.now().format(formatter), name, message));
    }
}
