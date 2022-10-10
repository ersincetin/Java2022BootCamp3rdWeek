package dataAccess;

import entities.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcCourseDao implements ICrudDao {
    private List<Course> courseList = new ArrayList<Course>();

    @Override
    public void add(Object object) {
        System.out.println("JDBC ile Ders veritabanına eklendi.");
        this.courseList.add((Course) object);
    }

    @Override
    public void update(Object object) {
        System.out.println("JDBC ile Ders Güncellendi");
    }

    @Override
    public void delete(Object object) {
        System.out.println("JDBC ile Ders Silindi");
    }

    @Override
    public Object getByItem(int index) throws Exception {
        System.out.println("JDBC ile getirildi");
        for (Course course : this.courseList) {
            if (course.getId() == index) {
                return course;
            }
        }
        throw new Exception("Ders Bulunamadı");
    }

    @Override
    public List<Object> getAllOfItems() {
        System.out.println("JDBC ile getirildi");
        return Collections.singletonList(this.courseList);
    }
}
