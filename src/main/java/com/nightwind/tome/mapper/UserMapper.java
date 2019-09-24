package com.nightwind.tome.mapper;

import com.nightwind.tome.bean.CommentBean;
import com.nightwind.tome.bean.LetterBean;
import com.nightwind.tome.bean.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户有关的数据库操作〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
@Mapper
public interface UserMapper {

    //通过userid查到对应的名字

    @Select(" SELECT annoyname" +
            " FROM user" +
            " WHERE userid=#{userid}")
    @Results({
            @Result(property = "userid",column = "userid",javaType = int.class),
            @Result(property = "username", column = "username", javaType = String.class),
            @Result(property = "userpwd", column = "userpwd", javaType = String.class),
            @Result(property = "annoyname", column = "annoyame", javaType = String.class)
    })
    List<UserBean> getUserByUserId(@Param("userid") int userid);


    //登录
    //通过用户名和密码查询查到了说明登录成功，并返回userbean对象，如果为null则返回空，登陆失败
    @Select(" SELECT *" +
            " FROM user" +
            " WHERE username=#{username} AND userpwd=#{userpwd}")
    @Results({
            @Result(property = "userid",column = "userid",javaType = int.class),
            @Result(property = "username", column = "username", javaType = String.class),
            @Result(property = "userpwd", column = "userpwd", javaType = String.class),
            @Result(property = "annoyname", column = "annoyame", javaType = String.class)
    })
    UserBean login(@Param("username") String username,@Param("userpwd") String userpwd);

    //验证用户名是否存在
    @Select(" SELECT *" +
            " FROM user" +
            " WHERE username=#{username}")
    @Results({
            @Result(property = "userid",column = "userid",javaType = int.class),
            @Result(property = "username", column = "username", javaType = String.class),
            @Result(property = "userpwd", column = "userpwd", javaType = String.class),
            @Result(property = "annoyname", column = "annoyame", javaType = String.class)
    })
    List<UserBean> isUsernameExisted(@Param("username") String username);

    //注册新用户
    @Insert("INSERT INTO letter (lettercontent,lettertime,letterurl) VALUES(#{username}, #{userpwd},#{annoyname})")
    void addUser(UserBean userBean);

}
