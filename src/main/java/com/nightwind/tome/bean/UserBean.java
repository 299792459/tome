package com.nightwind.tome.bean;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户信息实体类〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
public class UserBean {

    int userid;
    String username;
    String userpwd;
    String annoyname;

    List<LetterBean> userLetterBean;
    List<CommentBean> userCommentBean;

    public UserBean(int userid, String username, String userpwd, String annoyname) {
        this.userid = userid;
        this.username = username;
        this.userpwd = userpwd;
        this.annoyname = annoyname;
    }

    public UserBean()
    {}
    public UserBean(int userid, String username, String userpwd, String annoyname, List<LetterBean> userLetterBean, List<CommentBean> userCommentBean) {
        this.userid = userid;
        this.username = username;
        this.userpwd = userpwd;
        this.annoyname = annoyname;
        this.userLetterBean = userLetterBean;
        this.userCommentBean = userCommentBean;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getAnnoyname() {
        return annoyname;
    }

    public void setAnnoyname(String annoyname) {
        this.annoyname = annoyname;
    }

    public List<LetterBean> getUserLetterBean() {
        return userLetterBean;
    }

    public void setUserLetterBean(List<LetterBean> userLetterBean) {
        this.userLetterBean = userLetterBean;
    }

    public List<CommentBean> getUserCommentBean() {
        return userCommentBean;
    }

    public void setUserCommentBean(List<CommentBean> userCommentBean) {
        this.userCommentBean = userCommentBean;
    }
}
