package com.nightwind.tome.controller;

import com.nightwind.tome.bean.*;
import com.nightwind.tome.service.CommentService;
import com.nightwind.tome.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public List<getAllLettersByUrlBean> getAllLettersByurl()
    {

        currenturl=getCurrenturl();
        System.out.println(currenturl);
        return letterService.getAllLettersByurl(currenturl);

    }

    //点击查询此url下所有留言对应的评论
    @RequestMapping(value = "/getAllCommentsbyLetterId")
    @ResponseBody
    public Map<String,List<getAllCommentsByLetterIdBean>> getAllCommentsbyLetterId()
    {
        Map map=null;
        currenturl=getCurrenturl();
        List<Integer> lettersidlist=letterService.getLettersIdByUrl(currenturl);
        for(int i=0;i<lettersidlist.size();i++)
        {
            map.put(i+"",commentService.getAllCommentsByLetterId(lettersidlist.get(i).intValue()));
        }

        return map;
    }

    //点击发表留言
    @RequestMapping(value = "/addLetter")
    //@ResponseBody
    public void addLetter(@RequestBody Map map)
    {
        LetterBean letterBean =new LetterBean();
        //装载数据
        letterBean.setUserid((int)map.get("userid"));
        letterBean.setLettercontent((String)map.get("lettercontent"));
        letterBean.setLettertime((String)map.get("lettertime"));
        currenturl=getCurrenturl();
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
        commentBean.setUserid((int)map.get("userid"));
        commentBean.setCommentcontent((String)map.get("commentcontent"));
        commentBean.setCommenttime((String)map.get("commenttime"));
        commentBean.setReplyletterid((int)map.get("replyletterid"));
        commentBean.setReplyuserid((int)map.get("replyuserid"));

        commentService.addComment(commentBean);

    }

}
