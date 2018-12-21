package com.chapter2.chapter2.myBatis.mapper;

import com.chapter2.chapter2.myBatis.entity.ProductCategory;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface ProductCategoryMapper {
    @Insert("insert into product_category(category_name, category_type) values (#{categoryName, jdbcType = VARCHAR}, #{categoryType,jdbcType = INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into product_category(category_name,category_type) values (#{categoryName , jdbcType = VARCHAR}, #{productCategory , jdbcType = INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
        @Result(column = "category_id", property = "categoryId"),
        @Result(column = "category_name", property = "categoryName"),
        @Result(column = "category_type", property = "categoryType"),
    })
    List<ProductCategory> findByCategoryType(Integer type);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName, @Param("categoryType") Integer categoryType);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory category);

    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);
}
