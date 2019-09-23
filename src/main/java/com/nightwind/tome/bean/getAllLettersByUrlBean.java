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

    String annoyname;
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
