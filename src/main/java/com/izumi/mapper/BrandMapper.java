package com.izumi.mapper;

import com.izumi.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /***
     * 查询所有
     * @return
     */
    public List<Brand> selectAll();

    // 查看详情
    public Brand selectById(int id);
}
