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

    //单条件动态查询
    List<Brand> selectBySingleCondition(Brand brand);

    void add(Brand brand);

    void update(Brand brand);

    void deleteById(int id);


//    <!--    mapper类传来的数组会被封装成map集合, 默认key:array. value:这个数组-->
void deleteByIds(int[] ids);

//     把map集合的key设置为ids, 在xml中就可以直接用数组名称ids
//    void deleteByIds(@Param("ids") int[] ids);


}
