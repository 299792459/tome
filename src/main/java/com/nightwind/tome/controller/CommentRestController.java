package com.nightwind.tome.controller;



import com.nightwind.tome.Service.ArticleCommentService;
import com.nightwind.tome.bean.ArticleComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    //添加评论
    @RequestMapping(value = "/addLetter")
    @ResponseBody
    public void addComments(
            @RequestParam(value = "name", required = true) String user,
            @RequestParam(value = "content", required = true) String content,
            @RequestParam(value = "time", required = true) String time,
            HttpServletRequest request,
            HttpServletResponse response)
    {
        ArticleComment articleComment=new ArticleComment(user,content,time);
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

