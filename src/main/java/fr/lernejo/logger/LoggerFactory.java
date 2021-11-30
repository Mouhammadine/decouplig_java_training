package fr.lernejo.logger;

public class LoggerFactory {
    private static final Logger baseLogger = new CompositeLogger(
        new FileLogger("log.txt"),
        new ConsoleLogger()
    );

    public static Logger getLogger(String name) {
        return new ContextualLogger(baseLogger, name);
    }
}
