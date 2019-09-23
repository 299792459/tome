package com.nightwind.tome.bean;

/**
 * 〈一句话功能简述〉<br>
 * 〈通过回复的文章id得到其下所有评论〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
public class getAllCommentsByLetterIdBean {
    String annoyname;
    String commentcontent;
    String commenttime;
    String replyannoyname;

    public getAllCommentsByLetterIdBean(){}

    public getAllCommentsByLetterIdBean(String annoyname, String commentcontent, String commenttime, String replyannoyname) {
        this.annoyname = annoyname;
        this.commentcontent = commentcontent;
        this.commenttime = commenttime;
        this.replyannoyname = replyannoyname;
    }

    public String getAnnoyname() {
        return annoyname;
    }

    public void setAnnoyname(String annoyname) {
        this.annoyname = annoyname;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }

    public String getReplyannoyname() {
        return replyannoyname;
    }

    public void setReplyannoyname(String replyannoyname) {
        this.replyannoyname = replyannoyname;
    }
}
