package com.nightwind.tome.controller;

import com.nightwind.tome.Service.CommentService;
import com.nightwind.tome.Service.LetterService;
import com.nightwind.tome.bean.CommentBean;
import com.nightwind.tome.bean.LetterBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈首页控制〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */

@RestController
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    HttpServletRequest request; //这里可以获取到request
    @Autowired
    LetterService letterService;
    CommentService commentService;
    //当前地址
    String currenturl;


    /**
     * 进来直接进入主页，并记录下此页面的url
     *
     * 然后主页显示展示该url下所有的评论
     * @return
     */
    public String getCurrenturl(){
        currenturl= request.getScheme() //当前链接使用的协议
                +"://" + request.getServerName()//服务器地址
                + ":" + request.getServerPort() //端口号
                + request.getContextPath() //应用名称，如果应用名称为
                + request.getServletPath() //请求的相对url
                + "?" + request.getQueryString(); //请求参数
        return currenturl;
    }

    @RequestMapping(value = "")
    @ResponseBody
    public ModelAndView intoindex(){
        currenturl=getCurrenturl();
        ModelAndView mv = new ModelAndView("NightWind.html");
        return mv;
    }

    //点击登录
    @RequestMapping(value = "/Login")
    @ResponseBody
    public ModelAndView Login()
    {
        ModelAndView mv = new ModelAndView("Login.html");
        return mv;
    }

    //点击注册
    @RequestMapping(value = "/Regist")
    @ResponseBody
    public ModelAndView Regist()
    {
        ModelAndView mv = new ModelAndView("Regist.html");
        return mv;
    }

    //点击查询此url下所有留言
    @RequestMapping(value = "/getAllLettersByurl")
    @ResponseBody
    public List<LetterBean> getAllLettersByurl(String url)
    {
        return letterService.getAllLettersByurl("111");

    }

    //点击查询此url下所有留言对应的评论
    @RequestMapping(value = "/getAllCommentsbyLetterId")
    @ResponseBody
    public List<CommentBean> getAllCommentsbyLetterId(int letterid)
    {
        return commentService.getAllcommentsbyLetterId(letterid);

    }

    //点击发表留言
    @RequestMapping(value = "/addLetter")
    @ResponseBody
    public void addLetter(LetterBean letterBean)
    {
        letterService.addLetter(letterBean);
    }


    //点击发表评论
    @RequestMapping(value = "/addComment")
    @ResponseBody
    public void addComment(CommentBean commentBean)
    {
        commentService.addComment(commentBean);

    }

}
