package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.domain.Category;

public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String source) {
        return categoryDao.findCategoryById(Long.parseLong(source));
    }
}
