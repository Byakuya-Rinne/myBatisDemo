package com.mapper;

import com.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    public List<Brand> selectAll();

    public List<Brand> selectById(int id);
}
