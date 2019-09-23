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

public class LetterBean {
    private int letterid;//主键id
    private int userid;//评论人的昵称

    public int getLetterid() {
        return letterid;
    }

    public void setLetterid(int letterid) {
        this.letterid = letterid;
    }

    private String lettercontent;//评论内容
    private String lettertime;//评论的日期
    private String letterurl;//所发表留言的地址
    List<CommentBean> letterCommentBean;
    List<UserBean> letterUserBean;


    public LetterBean()
    {

    }
    public LetterBean(int userid, String lettercontent, String lettertime, String letterurl, int replyid) {
        this.userid = userid;
        this.lettercontent = lettercontent;
        this.lettertime = lettertime;
        this.letterurl = letterurl;

    }

    public int getUserid() {
        return userid;
    }

    public String getLettercontent() {
        return lettercontent;
    }

    public void setLettercontent(String lettercontent) {
        this.lettercontent = lettercontent;
    }

    public String getLettertime() {
        return lettertime;
    }



    public void setLettertime(String lettertime) {
        this.lettertime = lettertime;
    }

    public String getLetterurl() {
        return letterurl;
    }

    public void setLetterurl(String letterurl) {
        this.letterurl = letterurl;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}

