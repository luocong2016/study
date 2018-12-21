package com.chapter2.chapter2.myBatis.controll;

import com.chapter2.chapter2.myBatis.entity.ProductCategory;
import com.chapter2.chapter2.myBatis.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/findByCategoryType/{type}")
    public List<ProductCategory> getCategory(@PathVariable("type") Integer type) {
       return categoryService.findByCategoryType(type);
    }
}