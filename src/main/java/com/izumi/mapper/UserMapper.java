package com.izumi.mapper;

import com.izumi.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
   List<User> selectAll();

   // ×¢½âÐ´sql´úÂë
   @Select("select * from tb_brand where id = #{id}")
   User selectById(int d);
}
