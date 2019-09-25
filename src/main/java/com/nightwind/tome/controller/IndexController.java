package com.nightwind.tome.controller;

import com.nightwind.tome.bean.*;
import com.nightwind.tome.service.CommentService;
import com.nightwind.tome.service.LetterService;
import com.nightwind.tome.service.ServiceImpl.UserServiceImpl;
import com.nightwind.tome.service.UserService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    //@Autowired
     //这里可以获取到request
    @Autowired
    LetterService letterService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    //当前地址
    String currenturl;


    /**
     * 进来直接进入主页，并记录下此页面的url
     *
     * 然后主页显示展示该url下所有的评论
     * @return
     */
    public String getCurrenturl(HttpServletRequest request){
        currenturl= request.getScheme() //当前链接使用的协议
                +"://" + request.getServerName()//服务器地址
                + ":" + request.getServerPort() //端口号

                + request.getContextPath(); //应用名称，如果应用名称为
                //+ request.getServletPath();//请求的相对url
                //+ "?" + request.getQueryString(); //请求参数

        return currenturl;
    }

    @RequestMapping(value = "")
    @ResponseBody
    public ModelAndView intoindex(){

        ModelAndView mv = new ModelAndView("NightWind.html");
        return mv;
    }


    //点击查询此url下所有留言
    @RequestMapping(value = "/getAllLettersByurl")
    @ResponseBody
    public List<getAllLettersByUrlBean> getAllLettersByurl(HttpServletRequest request)
    {

        currenturl=getCurrenturl(request);
        System.out.println(currenturl);
        return letterService.getAllLettersByurl(currenturl);

    }

    //点击查询此url下所有留言对应的评论
    @RequestMapping(value = "/getAllCommentsbyLetterId")
    @ResponseBody
    public List getAllCommentsbyLetterId(HttpServletRequest request)
    {

        List relist=new ArrayList();
        currenturl=getCurrenturl(request);
        System.out.println(currenturl);
        List<Integer> lettersidlist=letterService.getLettersIdByUrl(currenturl);
        //List lettersidlist=new ArrayList();
        //lettersidlist.add(1);
        for(int i=0;i<lettersidlist.size();i++)
        {
            List<getAllCommentsByLetterIdBean> l=commentService.getAllCommentsByLetterId(lettersidlist.get(i).intValue());
            relist.add(l);
        }
        return relist;
    }

    //点击发表留言
    @RequestMapping(value = "/addLetter")
    //@ResponseBody
    public void addLetter(@RequestBody Map map,HttpServletRequest request)
    {
        LetterBean letterBean =new LetterBean();
        //装载数据
        letterBean.setUserid(userService.getIdByUserName((String)map.get("username")));
        letterBean.setLettercontent((String)map.get("lettercontent"));
        letterBean.setLettertime((String)map.get("lettertime"));
        currenturl=getCurrenturl(request);
        letterBean.setLetterurl(currenturl);
        letterService.addLetter(letterBean);

    }


    //点击发表评论
    @RequestMapping(value = "/addComment")
    //@ResponseBody
    public void addComment(@RequestBody Map map)
    {

        CommentBean commentBean =new CommentBean();
        //装载数据
        commentBean.setUserid(userService.getIdByUserName((String)map.get("username")));
        commentBean.setCommentcontent((String)map.get("commentcontent"));
        commentBean.setCommenttime((String)map.get("commenttime"));
        commentBean.setReplyletterid((int)map.get("replyletterid"));
        commentBean.setReplyuserid(userService.getIdByUserName((String)map.get("replyusername")));

        commentService.addComment(commentBean);

    }

}
