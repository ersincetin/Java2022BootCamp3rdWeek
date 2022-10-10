package business;

import core.logger.ILogger;
import dataAccess.ICrudDao;
import entities.Category;

import java.util.List;

public class CategoryManager {
    private ICrudDao iCrudDao;
    private List<ILogger> loggerList;

    public CategoryManager(ICrudDao iCrudDao, List<ILogger> loggerList) {
        this.iCrudDao = iCrudDao;
        this.loggerList = loggerList;
    }

    public void add(Category category) throws Exception {
        boolean isTrue = false;
        List<Object> categoryList = iCrudDao.getAllOfItems();
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).equals(category)) {
                isTrue = true;
                break;
            }
        }

        if(!isTrue) {
            iCrudDao.add(category);
            for(ILogger logger:loggerList) {
                logger.log(category.getName()+ " İsimli Kategori Oluşturuldu.");
            }
        }
        else {
            throw new Exception("Kategori ismi tekrar edemez");
        }
    }

    public void update(Category category){
        iCrudDao.update(category);
        for(ILogger logger:loggerList) {
            logger.log(category.getName()+ " İsimli Kategori Güncellendi.");
        }
    }

    public void delete(Category category){
        iCrudDao.delete(category);
        for(ILogger logger:loggerList) {
            logger.log(category.getName()+ " İsimli Kategori Silindi.");
        }
    }
}
