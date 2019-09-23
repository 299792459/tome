package com.nightwind.tome.bean;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈评论实体类〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
public class CommentBean {
    int commentid;
    int userid;
    String commentcontent;
    String commenttime;
    int replyletterid;
    int replyuserid;

    List<LetterBean> commentLetterBean;
    List<UserBean> commentUserBean;
    public CommentBean()
    {

    }
    public CommentBean(int commentid, int userid, String commentcontent, String commenttime, int replyletterid, int replyuserid) {
        this.commentid = commentid;
        this.userid = userid;
        this.commentcontent = commentcontent;
        this.commenttime = commenttime;
        this.replyletterid = replyletterid;
        this.replyuserid = replyuserid;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public int getReplyletterid() {
        return replyletterid;
    }

    public void setReplyletterid(int replyletterid) {
        this.replyletterid = replyletterid;
    }

    public int getReplyuserid() {
        return replyuserid;
    }

    public void setReplyuserid(int replyuserid) {
        this.replyuserid = replyuserid;
    }
}
