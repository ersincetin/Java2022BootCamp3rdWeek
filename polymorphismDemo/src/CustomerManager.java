public class CustomerManager {
    private BaseLogger baseLogger;

    public CustomerManager(BaseLogger baseLogger) {
        this.baseLogger = baseLogger;
    }

    public void Add() {
        System.out.println("Musteri eklendi.");
        this.baseLogger.log("Logged of message");
    }
}
