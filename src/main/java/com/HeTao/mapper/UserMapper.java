package com.HeTao.mapper;

import com.HeTao.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    /**
     * �����û����������ѯ�û�����
     * @param username �û���
     * @param password ����
     * @return User����
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password")  String password);

    /**
     * �����û�����ѯ�û�����
     * @param username �û���
     * @return User����
     */
    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(String username);

    /**
     * ����û�
     * @param user �û�����
     */
    @Insert("insert into tb_user values(null,#{username},#{password})")
    void add(User user);
}
