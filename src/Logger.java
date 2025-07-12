import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Logger - абстрактный класс, описывающий процесс логирования
public abstract class Logger {
    // уровни логирования
    public enum LogLevel {
        DEBUG(1),
        INFO(2),
        ERROR(3);

        private final int level;

        LogLevel(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }
    // уровень логирования
    protected LogLevel level;
    // следующий логгер в цепочке обязанностей
    protected Logger nextLogger;

    // ctor
    public Logger(LogLevel level) {
        this.level = level;
    }
    public Logger(LogLevel level, Logger nextLogger) {
        this.level = level;
        this.nextLogger = nextLogger;
    }

    // setter
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    // log - метод для логирования, реализующий цепочку обязанностей
    public void log(String message, LogLevel messageLevel){
        if (this.level == messageLevel) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.log(message, messageLevel);
        }
    }

    protected String formatMessage(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return "[" + now.format(formatter) + "][" + level + "] " + message;
    }

    protected abstract void write(String message);
}
