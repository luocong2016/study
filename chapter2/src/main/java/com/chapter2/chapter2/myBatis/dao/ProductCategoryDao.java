package com.chapter2.chapter2.myBatis.dao;

import com.chapter2.chapter2.myBatis.entity.ProductCategory;
import com.chapter2.chapter2.myBatis.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductCategoryDao {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    public List<ProductCategory> findByCategoryType(Integer type) {
        return productCategoryMapper.findByCategoryType(type);
    }
}
