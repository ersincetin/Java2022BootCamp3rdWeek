public class MySqlCustomerDal implements ICustomerDal, IRepository {
    @Override
    public void Create() {
        System.out.println("Veri MySQL e eklendi.");
    }
}
