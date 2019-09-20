package com.nightwind.tome.bean;




import java.util.List;
/**
 * 〈一句话功能简述〉<br>
 * 〈评论的实体类〉
 *
 * @author 陈景
 * @create 2019/9/19 0019
 * @since StaticConfigParam.0.0
 */

public class ArticleComment {
    //private int id;//主键id
    private String name;//评论人的昵称
    private String content;//评论内容
    private String time;//评论的日期



    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public ArticleComment(){}
    public ArticleComment(String name,String content,String time){
        this.content=content;
        this.name=name;
        this.time=time;
    }
}

