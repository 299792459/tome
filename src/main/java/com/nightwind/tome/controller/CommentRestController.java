package com.nightwind.tome.controller;



import com.nightwind.tome.Service.ArticleCommentService;
import com.nightwind.tome.bean.ArticleComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在controller里面通过
 * autowired注入需要的service来操作数据库
 *      service调用mapper映射数据库
 * requestmapping来得到前台的路径
 * ResponseBody对前台请求进行响应
 * RequestParam得到前台传过来的值
 *
 */
@RestController
@EnableAutoConfiguration
public class CommentRestController {
    @Autowired
    private ArticleCommentService articleCommentService;

    //进来直接进入主页
    @RequestMapping(value = "")
    @ResponseBody
    public ModelAndView  intoindex(){

        ModelAndView mv = new ModelAndView("NightWind.html");
        return mv;
    }
    //测试页
    @RequestMapping(value = "/testlinux")
    @ResponseBody
    public String  testlinux(){
        return "test sucess!测试成功linux环境部署";
    }

    //添加评论
    @RequestMapping(value = "/addLetter")

    public void addComments(@RequestBody Map map)
    {
        System.out.println((String)map.get("userName"));
        ArticleComment articleComment=new ArticleComment((String)map.get("userName"),(String)map.get("content"),(String)map.get("time"));
        //System.out.println(articleComment);
        articleCommentService.addArticleComment(articleComment);
        //插入以后要显示所有的评论
        getComments();
    }

    //返回查询到的列表
    @RequestMapping(value = "/getLetters")
    @ResponseBody
    public List<ArticleComment> getComments() {


            return articleCommentService.getArticleComment();

    }

}

