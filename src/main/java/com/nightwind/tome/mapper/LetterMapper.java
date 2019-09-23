package com.nightwind.tome.mapper;




import com.nightwind.tome.bean.LetterBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LetterMapper {

    //column是数据库对应字段
    //property是实体类对应的字段

    //显示当前url下所有留言,即replyletterid=0的
    @Select(" SELECT annoyname,lettercontent,lettertime" +
            " FROM user,letter" +
            " WHERE user.userid=letter.userid AND letterurl=#{letterurl}")
    @Results({
            @Result(property = "annoyname", column = "annoyname", javaType = String.class),
            @Result(property = "lettercontent",  column = "lettercontent", javaType = String.class),
            @Result(property = "lettertime", column = "lettertime", javaType = String.class)
    })
    List<LetterBean> getAllLettersByurl(@Param("letterurl") String letterurl);





    //发表一条留言
    @Insert("INSERT INTO letter (name,content,time) VALUES(#{name}, #{content}, #{time})")
    void addLetter(LetterBean oneletter);


}
