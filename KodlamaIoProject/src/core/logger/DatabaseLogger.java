package core.logger;

public class DatabaseLogger implements ILogger{
    @Override
    public void log(String data) {
        System.out.println("Veritabanına Loglandı : "+data);
    }
}
