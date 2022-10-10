package core.logger;

public class SmsLogger implements ILogger {
    @Override
    public void log(String data) {
        System.out.println("SMS olarak Loglandı : " + data);
    }
}
