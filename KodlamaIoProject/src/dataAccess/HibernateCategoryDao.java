package dataAccess;

import entities.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HibernateCategoryDao implements ICrudDao{
    private List<Category> categoryList = new ArrayList<Category>();
    @Override
    public void add(Object object) {
        System.out.println("Hibernate ile Kategori veritabanına eklendi.");
        this.categoryList.add((Category) object);
    }

    @Override
    public void update(Object object) {
        System.out.println("Hibernate ile Kategori Güncellendi");
    }

    @Override
    public void delete(Object object) {
        System.out.println("Hibernate ile Kategori Silindi");
    }

    @Override
    public Object getByItem(int index) throws Exception {
        System.out.println("Hibernate ile Kategori getirildi");
        for (Category category : this.categoryList) {
            if (category.getId() == index) {
                return category;
            }
        }
        throw new Exception("Kategori Bulunamadı");
    }

    @Override
    public List<Object> getAllOfItems() {
        System.out.println("Hibernate ile Kategori Listesi getirildi");
        return Collections.singletonList(this.categoryList);
    }
}
