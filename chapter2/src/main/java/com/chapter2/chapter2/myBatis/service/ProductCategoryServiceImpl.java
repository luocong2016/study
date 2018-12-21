package com.chapter2.chapter2.myBatis.service;

import com.chapter2.chapter2.myBatis.entity.ProductCategory;
import com.chapter2.chapter2.myBatis.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> findByCategoryType(Integer type) {
        return productCategoryMapper.findByCategoryType(type);
    }
}
