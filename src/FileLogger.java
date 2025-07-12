import java.io.FileOutputStream;
import java.io.IOException;


public class FileLogger extends Logger{
    private final String fileName;
    {
        fileName = "log.txt";
    }

    public FileLogger(LogLevel level) {
        super(level);
    }
    public FileLogger(LogLevel level, Logger nextLogger) {
        super(level, nextLogger);
    }
    @Override
    protected void write(String message) {
        try(FileOutputStream fos = new FileOutputStream(fileName, true))
        {
            String formattedMessage = formatMessage(message);
            byte[] buffer = formattedMessage.getBytes();
            fos.write(buffer, 0, buffer.length);
            fos.write('\n');
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
