package com.izumi.mapper;

import com.izumi.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /***
     * ��ѯ����
     * @return
     */
    public List<Brand> selectAll();

    // �鿴����
    public Brand selectById(int id);
}
