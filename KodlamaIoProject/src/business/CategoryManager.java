package business;

import core.logger.ILogger;
import dataAccess.ICrudDao;
import entities.Category;

import java.util.List;

public class CategoryManager {
    private ICrudDao iCrudDao;
    private List<ILogger> loggerList;
    private List<Object> categoryList;

    public CategoryManager(ICrudDao iCrudDao, List<ILogger> loggerList) {
        this.iCrudDao = iCrudDao;
        this.loggerList = loggerList;
        this.categoryList = iCrudDao.getAllOfItems();
    }

    public void add(Category category) throws Exception {
        boolean isTrue = false;
        for (Object categoryItems : categoryList) {
            for (Object item : (List) categoryItems) {
                if (item.equals(category)) {
                    isTrue = true;
                    break;
                }
            }
        }
        if (!isTrue) {
            iCrudDao.add(category);
            for (ILogger logger : loggerList) {
                logger.log(category.getName() + " İsimli Kategori Oluşturuldu.");
            }
        } else {
            throw new Exception("Kategori ismi tekrar edemez");
        }
    }

    public void update(Category category) {
        iCrudDao.update(category);
        for (ILogger logger : loggerList) {
            logger.log(category.getName() + " İsimli Kategori Güncellendi.");
        }
    }

    public void delete(Category category) {
        iCrudDao.delete(category);
        for (ILogger logger : loggerList) {
            logger.log(category.getName() + " İsimli Kategori Silindi.");
        }
    }
}
