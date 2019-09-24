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
    @Select(" SELECT *" +
            " FROM comment" +
            " WHERE replyletterid=#{replyletterid}")
    @Results({
            @Result(property = "commentid", column = "commentid", javaType = int.class),
            @Result(property = "userid", column = "userid", javaType = int.class),
            @Result(property = "commentcontent", column = "commentcontent", javaType = String.class),
            @Result(property = "commenttime", column = "commenttime", javaType = String.class),
            @Result(property = "replyletterid", column = "replyletterid", javaType = int.class),
            @Result(property = "replyuserid", column = "replyuserid", javaType = int.class)
    })
    List<CommentBean> getAllCommentsByLetterId(@Param("replyletterid") int replyletterid);


    //发表一条评论
    @Insert("INSERT into `comment`(userid,commentcontent,commenttime,replyletterid,replyuserid) " +
            "VALUES(#{userid}, #{commentcontent}, #{commenttime}, #{replyletterid}, #{replyuserid})")
    void addComment(CommentBean onecomment);
}
