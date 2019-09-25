package com.nightwind.tome.bean;

/**
 * 〈一句话功能简述〉<br>
 * 〈通过url获得留言的实体类〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
public class getAllLettersByUrlBean {

    int letterid;
    String annoyname;

    public int getLetterid() {
        return letterid;
    }

    public getAllLettersByUrlBean(int letterid, String annoyname, String lettercontent, String lettertime) {
        this.letterid = letterid;
        this.annoyname = annoyname;
        this.lettercontent = lettercontent;
        this.lettertime = lettertime;
    }

    public void setLetterid(int letterid) {
        this.letterid = letterid;
    }

    public String getLettertime() {
        return lettertime;
    }

    public void setLettertime(String lettertime) {
        this.lettertime = lettertime;
    }

    String lettercontent;
    String lettertime;

    public getAllLettersByUrlBean(){}

    public getAllLettersByUrlBean(String annoyname, String lettercontent, String ettertime) {
        this.annoyname = annoyname;
        this.lettercontent = lettercontent;
        this.lettertime = lettertime;
    }

    public String getAnnoyname() {
        return annoyname;
    }

    public void setAnnoyname(String annoyname) {
        this.annoyname = annoyname;
    }

    public String getLettercontent() {
        return lettercontent;
    }

    public void setLettercontent(String lettercontent) {
        this.lettercontent = lettercontent;
    }

    public String getEttertime() {
        return lettertime;
    }

    public void setEttertime(String ettertime) {
        this.lettertime = ettertime;
    }
}
