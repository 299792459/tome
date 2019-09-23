package com.nightwind.tome.mapper;

import com.nightwind.tome.bean.CommentBean;
import com.nightwind.tome.bean.LetterBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈评论有关的数据库操作〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */

@Mapper
public interface CommentMapper {

    //显示当前留言下所有评论
    @Select(" SELECT annoyname,lettercontent,lettertime,replyuserid" +
            " FROM user,letter,comment" +
            " WHERE user.userid=letter.userid AND user.userid=comment.userid AND replyletterid=#{replyletterid}")
    @Results({
            @Result(property = "annoyname", column = "annoyname", javaType = String.class),
            @Result(property = "lettercontent", column = "lettercontent", javaType = String.class),
            @Result(property = "lettertime", column = "lettertime", javaType = String.class)
    })
    List<CommentBean> getAllcommentsbyLetterId(int letterid);


    //发表一条评论
    @Insert("INSERT INTO letter (name,content,time) VALUES(#{name}, #{content}, #{time})")
    void addComment(CommentBean onecomment);
}
