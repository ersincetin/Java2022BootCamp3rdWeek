package dataAccess;

import entities.Instructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcInstructorDao implements ICrudDao {
    private List<Instructor> instructorList = new ArrayList<Instructor>();

    @Override
    public void add(Object object) {
        System.out.println("JDBC ile Eğitmen veritabanına eklendi.");
        this.instructorList.add((Instructor) object);
    }

    @Override
    public void update(Object object) {
        System.out.println("JDBC ile Eğitmen Güncellendi");
    }

    @Override
    public void delete(Object object) {
        System.out.println("JDBC ile Eğitmen Silindi");
    }

    @Override
    public Instructor getByItem(int index) throws Exception {
        System.out.println("JDBC ile getirildi");
        for (Instructor instructor : this.instructorList) {
            if (instructor.getId() == index) {
                return instructor;
            }
        }
        throw new Exception("Eğitmen Bulunamadı");
    }

    @Override
    public List<Object> getAllOfItems() {
        System.out.println("JDBC ile Eğitimciler getirildi");
        return Collections.singletonList(this.instructorList);
    }
}
