import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logger.DatabaseLogger;
import core.logger.FileLogger;
import core.logger.ILogger;
import core.logger.SmsLogger;
import dataAccess.HibernateCategoryDao;
import dataAccess.HibernateInstructorDao;
import dataAccess.JdbcCourseDao;
import dataAccess.JdbcInstructorDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Instructor instructor1 = new Instructor(1, "ersincetin", "Ersin", "Çetin", "");
        Instructor instructor2 = new Instructor(1, "engindemirog", "Engin", "Demiroğ", "");

        Category category1 = new Category(1, "Tümü");
        Category category2 = new Category(2, "Programlama");
        Category category3 = new Category(3, "Veritabı");
        Category category4 = new Category(4, "Yazılım");

        Course course1 = new Course(1, "Java ile Programlama Öğreniyorum", 250, category2, instructor1);
        Course course2 = new Course(2, "C# ile Programlama Öğreniyorum", 125, category2, instructor1);
        //Course course3 = new Course(3, "MySQL ile Veritabanı Öğreniyorum", -1, category3, instructor1);

        List<ILogger> loggers = new ArrayList<>();
        loggers.add(new DatabaseLogger());
        loggers.add(new FileLogger());
        //loggers.add(new SmsLogger());

        System.out.println("******* Instructor Operation Field******************************");
        InstructorManager instructorManager1 = new InstructorManager(new HibernateInstructorDao(), loggers);
        instructorManager1.add(instructor1);
        InstructorManager instructorManager2 = new InstructorManager(new JdbcInstructorDao(), loggers);
        instructorManager2.add(instructor2);

        System.out.println("\n******* Category Operation Field******************************");
        CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), loggers);
        categoryManager.add(category1);
        categoryManager.add(category2);
        /*Bunu eklediğimizde exception fırlatır*/
//        categoryManager.add(category2);

        System.out.println("\n******* Course Operation Field******************************");
        CourseManager courseManager = new CourseManager(new JdbcCourseDao(), loggers);
        courseManager.add(course1);
        courseManager.add(course2);
        courseManager.add(course3);
        /*Bu kısmı eklediğimizde exception fırlatılır*/
//        courseManager.add(course2);

    }
}