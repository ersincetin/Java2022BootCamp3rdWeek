package dataAccess;

import java.util.List;

public interface ICrudDao {
    void add(Object object);
    void update(Object object);
    void delete(Object object);
    Object getByItem(int index) throws Exception;
    List<Object> getAllOfItems();
}
