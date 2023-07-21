package com.mapper;

import com.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();

    List<Brand> selectById(int id);

//  条件查询 散装参数 @Param("参数#{ }占位符名称, 用类里的属性名"),
//  对象参数,
//  map集合参数
    List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName,@Param("brandName")String brandName);

    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);

}
