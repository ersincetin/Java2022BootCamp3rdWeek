public class CustomerManager {
    BaseDatabaseManager baseDatabaseManager;

//    public CustomerManager(BaseDatabaseManager baseDatabaseManager) {
//        this.baseDatabaseManager = baseDatabaseManager;
//    }

    public void getCustomer() {
        baseDatabaseManager.getData();
    }
}
