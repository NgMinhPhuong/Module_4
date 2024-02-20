package com.codegym.practicecart.formatter;

import com.codegym.practicecart.model.Product;
import com.codegym.practicecart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProductFormatter implements Formatter<Product> {

    private IProductService iProductService;

    @Autowired
    public ProductFormatter(IProductService iProductService) {
        this.iProductService = iProductService;
    }


    @Override
    public Product parse(String text, Locale locale) throws ParseException {
        return iProductService.findById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Product object, Locale locale) {
        return null;
    }
}
