package com.nightwind.tome.mapper;

import com.nightwind.tome.bean.CommentBean;
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


}
