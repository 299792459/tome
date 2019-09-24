package com.nightwind.tome.controller;

import com.nightwind.tome.bean.LetterBean;
import com.nightwind.tome.bean.UserBean;
import com.nightwind.tome.bean.getAllCommentsByLetterIdBean;
import com.nightwind.tome.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈注册控制〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
@RestController
@EnableAutoConfiguration
public class RegistController {


    @Autowired
    UserMapper userMapper;
    //点击查询此url下所有留言对应的评论
    @RequestMapping(value = "/regist")
    @ResponseBody
    public UserBean regist(@RequestBody Map map)
    {
        UserBean userBean=new UserBean();
        userBean.setAnnoyname((String) map.get("annoyname"));
        userBean.setAnnoyname((String) map.get("username"));
        userBean.setAnnoyname((String) map.get("userpwd"));


        return userBean;
    }



}
