//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // цепочка логгеров
        Logger errorFileLogger = new FileLogger(Logger.LogLevel.ERROR, null);
        Logger errorConsoleLogger = new ConsoleLogger(Logger.LogLevel.ERROR, errorFileLogger);
        Logger infoFileLogger = new FileLogger(Logger.LogLevel.INFO, errorConsoleLogger);
        Logger infoConsoleLogger = new ConsoleLogger(Logger.LogLevel.INFO, infoFileLogger);
        Logger debugConsoleLogger = new ConsoleLogger(Logger.LogLevel.DEBUG, infoConsoleLogger);

        Logger logger = debugConsoleLogger;

        logger.log("Ошибка подключения к БД", Logger.LogLevel.ERROR);
        logger.log("Отладка конфигурации сервера", Logger.LogLevel.DEBUG);
        logger.log("Пользователь вошел в систему", Logger.LogLevel.INFO);
        logger.log("Ошибка при чтении файла", Logger.LogLevel.ERROR);
        logger.log("Загрузка завершена", Logger.LogLevel.INFO);
        logger.log("Отладка интерфейса администратора", Logger.LogLevel.DEBUG);
        logger.log("Файл конфигурации найден", Logger.LogLevel.INFO);
        logger.log("Ошибка авторизации", Logger.LogLevel.ERROR);
        logger.log("Проверка отладочного режима", Logger.LogLevel.DEBUG);
        logger.log("Отладка: состояние памяти", Logger.LogLevel.DEBUG);

    }
}