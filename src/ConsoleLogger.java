public class ConsoleLogger extends Logger {

    public ConsoleLogger(LogLevel level) {
        super(level);
    }
    public ConsoleLogger(LogLevel level, Logger nextLogger) {
        super(level, nextLogger);
    }
    @Override
    protected void write(String message) {
        System.out.println(formatMessage(message));
    }
}
