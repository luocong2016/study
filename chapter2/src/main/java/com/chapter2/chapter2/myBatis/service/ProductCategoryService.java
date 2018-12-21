package com.chapter2.chapter2.myBatis.service;

import com.chapter2.chapter2.myBatis.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> findByCategoryType(Integer type);
}
