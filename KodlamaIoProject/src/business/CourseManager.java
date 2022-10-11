package business;

import core.logger.ILogger;
import dataAccess.ICrudDao;
import entities.Course;

import java.util.List;

public class CourseManager {

    private List<ILogger> loggerList;
    private ICrudDao iCrudDao;
    private List<Object> courseList;

    public CourseManager(ICrudDao iCrudDao, List<ILogger> loggerList) {
        this.loggerList = loggerList;
        this.iCrudDao = iCrudDao;
        this.courseList = iCrudDao.getAllOfItems();
    }

    public void add(Course course) throws Exception {
        boolean isTrue = false;
        for (Object courseItems : courseList) {
            for (Object item:(List)courseItems){
                if (item.equals(course)) {
                    isTrue = true;
                    break;
                }
            }
        }
        if (course.getPrice() < 0) {
            throw new Exception("Bir kursun fiyatı 0 dan küçük olamaz");
        } else if (!isTrue && !(course.getPrice() < 0)) {
            iCrudDao.add(course);
            for (ILogger logger : loggerList) {
                logger.log(course.getName() + " Adlı Kurs Eklendi");
            }
        } else {
            throw new Exception("Kurs ismi tekrar edemez");
        }
    }

    public void update(Course course) {
        iCrudDao.update(course);
        for (ILogger logger : loggerList) {
            logger.log(course.getName() + " Adlı Kurs Güncellendi");
        }
    }

    public void delete(Course course) {
        iCrudDao.delete(course);
        for (ILogger logger : loggerList) {
            logger.log(course.getName() + " Adlı Kurs Silindi");
        }
    }
}
