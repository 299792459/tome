package com.nightwind.tome.mapper;


import com.nightwind.tome.bean.CommentBean;
import com.nightwind.tome.bean.LetterBean;
import com.nightwind.tome.bean.getAllLettersByUrlBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LetterMapper {

    //column是数据库对应字段
    //property是实体类对应的字段

    /**
     * int commentid;
     *     int userid;
     *     String commentcontent;
     *     String commenttime;
     *     int replyletterid;
     *     int replyuserid;
     * @param letterurl
     * @return
     */


    //显示当前url下所有留言
    @Select(" SELECT annoyname,lettercontent,lettertime" +
            " FROM letter,user" +
            " WHERE user.userid=letter.userid AND letterurl=#{letterurl}")
    @Results({
            @Result(property = "annoyname", column = "annoyname", javaType = String.class),
            @Result(property = "lettercontent",  column = "lettercontent", javaType = String.class),
            @Result(property = "lettertime", column = "lettercontent", javaType = int.class)
    })
    List<getAllLettersByUrlBean> getAllLettersByUrl(@Param("letterurl") String letterurl);

    //通过url查找所有letterid装在list里面
    @Select(" SELECT letterid" +
            " FROM letter" +
            " WHERE letterurl=#{letterurl}")
    @Results({
            @Result(property = "letterid", column = "letterid", javaType = Integer.class),
    })
    List<Integer> getLettersIdByUrl(@Param("letterurl") String letterurl);



    //发表一条留言
    @Insert("INSERT INTO letter (userid,lettercontent,lettertime,letterurl) VALUES(#{userid}, #{lettercontent}, #{lettertime},#{letterurl})")
    void addLetter(LetterBean letterBean);


}
