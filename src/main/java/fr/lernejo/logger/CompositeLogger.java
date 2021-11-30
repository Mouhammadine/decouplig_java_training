package fr.lernejo.logger;

public class CompositeLogger implements Logger {
    private final Logger loggerA;
    private final Logger loggerB;

    public CompositeLogger(Logger loggerA, Logger loggerB) {
        this.loggerA = loggerA;
        this.loggerB = loggerB;
    }

    @Override
    public void log(String message) {
        this.loggerA.log(message);
        this.loggerB.log(message);
    }
}
