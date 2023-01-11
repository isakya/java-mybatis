package com.izumi.mapper;

import com.izumi.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /***
     * ��ѯ����
     * @return
     */
    public List<Brand> selectAll();

    // �鿴����
    public Brand selectById(int id);



    // ������ѯ
    /**
     * �������գ�
     *  1. ɢװ����: ����������ж����������Ҫʹ��@Param("SQL����ռλ������")
     *  2. �������
     *  3. map���ϲ���
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





    // ��������ѯ
    List<Brand> selectByConditionSingle(Brand brand);


    // ���
    void add(Brand brand);


    // �޸�
    int update(Brand brand);

    // ɾ��
    void deleteById(int id);

    // ����ɾ��
    void deleteByIds(@Param("ids")int[] ids);
}
