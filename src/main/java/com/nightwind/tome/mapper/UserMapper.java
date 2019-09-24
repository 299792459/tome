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

    //通过userid查到对应的user
    @Select(" SELECT *" +
            " FROM user" +
            " WHERE userid=#{userid}")
    @Results({
            @Result(property = "userid",column = "userid",javaType = int.class),
            @Result(property = "username", column = "username", javaType = String.class),
            @Result(property = "userpwd", column = "userpwd", javaType = String.class),
            @Result(property = "annoyname", column = "annoyame", javaType = String.class)
    })
    List<UserBean> getUserByUserId(@Param("userid") int userid);



    //查询用户名是否存在
    @Select("SELECT count(*) FROM user WHERE username = #{username} ")
    @Results({
            @Result(property = "count", column = "count(*)", javaType = int.class)
    })
    int checkUserName(UserBean userBean);

    // 根据用户名查询密码
    @Select("SELECT count(*) FROM user WHERE username = #{username} AND userpwd = #{userpwd}")
    @Results({
            @Result(property = "count", column = "count(*)", javaType = int.class)
    })
    int getPwd(UserBean userBean);

    //注册
    @Insert("INSERT INTO user (username,userpwd,annoyname) VALUES(#{username},#{userpwd},#{annoyname})")
    void regist(UserBean userBean);


    // 向根据用户名查id
    @Select(" SELECT userid" +
            " FROM user" +
            " WHERE username=#{username}")
    @Results({
            @Result(property = "userid",column = "userid",javaType = int.class)
    })
    int getIdByUserName(@Param("username") String username);
}
