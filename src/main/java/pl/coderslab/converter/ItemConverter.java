package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.ItemDao;
import pl.coderslab.domain.Item;

public class ItemConverter implements Converter<String, Item>{

    @Autowired
    private ItemDao itemDao;

    @Override
    public Item convert(String source) {return itemDao.findById(Long.parseLong(source));}
}
