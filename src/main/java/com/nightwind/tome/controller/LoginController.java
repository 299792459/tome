package com.nightwind.tome.controller;

import com.nightwind.tome.bean.LetterBean;
import com.nightwind.tome.bean.UserBean;
import com.nightwind.tome.bean.getAllCommentsByLetterIdBean;
import com.nightwind.tome.service.UserService;
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
 * 〈登录〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
@RestController
@EnableAutoConfiguration
public class LoginController {

    @Autowired
    UserService userService;


    //在客户端判断，如果为空则是登陆失败，不为空则把整个值存储起来。


    @RequestMapping("/checkExist")
    @ResponseBody
    public boolean checkExist(@RequestBody Map map)
    {
        UserBean userBean=new UserBean();
        userBean.setUsername((String) map.get("username"));
        userBean.setUserpwd((String)map.get("userpwd"));
        System.out.println(userService.getPwd(userBean));
        return userService.getPwd(userBean)==1;

    }
}
