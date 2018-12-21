package com.chapter2.chapter2.myBatis;

import com.chapter2.chapter2.myBatis.entity.ProductCategory;
import com.chapter2.chapter2.myBatis.mapper.ProductCategoryMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap();
        map.put("categoryName", "我的最爱");
        map.put("categoryType", 20);
        int insertResult = productCategoryMapper.insertByMap(map);
        Assert.assertEquals(1, insertResult);
    }

    @Test
    public void insertByObject() throws Exception{
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("我讨厌的");
        productCategory.setCategoryType(17);
        int insertResult = productCategoryMapper.insertByObject(productCategory);
        Assert.assertEquals(1, insertResult);
    }

    @Test
    public void findByCategoryType() throws Exception {
        List<ProductCategory> productCategory = productCategoryMapper.findByCategoryType(17);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void updateByCategoryType() throws Exception {
        int updateResult = productCategoryMapper.updateByCategoryType("我讨厌的食物",17);
        Assert.assertEquals(1,updateResult);
    }

    @Test
    public void updateByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("我讨厌的");
        productCategory.setCategoryType(17);
        int updateResult = productCategoryMapper.updateByObject(productCategory);
        Assert.assertEquals(1,updateResult);
    }

    @Test
    public void deleteByCategoryType() throws Exception {
        int deleteResult = productCategoryMapper.deleteByCategoryType(20);
        Assert.assertEquals(1,deleteResult);
    }
}
