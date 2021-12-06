package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    Logger log1;
    Logger log2;

    public CompositeLogger(Logger l1, Logger l2) {
        log1 = l1;
        log2 = l2;
    }

    @Override
    public void log(String message) {
        log1.log(message);
        log2.log(message);
    }
}
