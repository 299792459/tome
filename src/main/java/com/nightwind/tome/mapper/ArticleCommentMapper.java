package com.nightwind.tome.mapper;




import com.nightwind.tome.bean.ArticleComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleCommentMapper {

    //显示所有评论
    @Select("SELECT name,content,time FROM letter")
    @Results({
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "content",  column = "content", javaType = String.class),
            @Result(property = "time", column = "time", javaType = String.class)
    })
    List<ArticleComment> getAll();

    //新建一条评论
    @Insert("INSERT INTO letter (name,content,time) VALUES(#{name}, #{content}, #{time})")
    void insert(ArticleComment oneletter);
}
