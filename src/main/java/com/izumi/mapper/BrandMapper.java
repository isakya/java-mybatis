package com.izumi.mapper;

import com.izumi.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /***
     * 查询所有
     * @return
     */
    public List<Brand> selectAll();

    // 查看详情
    public Brand selectById(int id);



    // 条件查询
    /**
     * 参数接收：
     *  1. 散装参数: 如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
     *  2. 对象参数
     *  3. map集合参数
     */

    /* 1.
    List<Brand> selectByCondition(@Param("status") int status,
                                  @Param("companyName") String companyName,
                                  @Param("brandName") String brandName);

     */

    /* 2.
    List<Brand> selectByCondition(Brand brand);

     */

    // 3.
    List<Brand> selectByCondition(Map map);





    // 单条件查询
    List<Brand> selectByConditionSingle(Brand brand);


    // 添加
    void add(Brand brand);


    // 修改
    int update(Brand brand);

    // 删除
    void deleteById(int id);

    // 批量删除
    void deleteByIds(@Param("ids")int[] ids);
}
