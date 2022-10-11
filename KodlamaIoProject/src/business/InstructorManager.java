package business;

import core.logger.ILogger;
import dataAccess.ICrudDao;
import entities.Instructor;

import java.util.List;

public class InstructorManager {
    private ICrudDao iCrudDao;
    private List<ILogger> loggerList;

    public InstructorManager(ICrudDao iCrudDao, List<ILogger> loggerList) {
        this.iCrudDao = iCrudDao;
        this.loggerList = loggerList;
    }

    public void add(Instructor instructor) {
        iCrudDao.add(instructor);
        for (ILogger logger : this.loggerList) {
            logger.log("Eğitimci " + instructor.getName() + " " + instructor.getLastname() + " Eklendi");
        }
    }

    public void update(Instructor instructor) {
        iCrudDao.update(instructor);
        for (ILogger logger : this.loggerList) {
            logger.log("Eğitimci " + instructor.getName() + " " + instructor.getLastname() + " Güncellendi");
        }
    }

    public void delete(Instructor instructor) {
        iCrudDao.delete(instructor);
        for (ILogger logger : this.loggerList) {
            logger.log("Eğitimci " + instructor.getName() + " " + instructor.getLastname() + " Silindi");
        }
    }
}
