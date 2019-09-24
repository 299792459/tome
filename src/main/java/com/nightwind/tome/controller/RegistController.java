package com.nightwind.tome.controller;

import com.nightwind.tome.bean.LetterBean;
import com.nightwind.tome.bean.UserBean;
import com.nightwind.tome.bean.getAllCommentsByLetterIdBean;
import com.nightwind.tome.mapper.UserMapper;
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
    @Autowired
    UserService userService;
    //点击进入注册
    @RequestMapping("/checkUserName")
    @ResponseBody
    public Boolean checkUserName(@RequestBody Map map) {
        UserBean userBean=new UserBean();
        userBean.setUsername((String) map.get("username"));
        return userService.checkUserName(userBean) == 0;
    }


    @RequestMapping("/regist")
    @ResponseBody
    public void regist(@RequestBody Map map)
    {
        UserBean userBean=new UserBean();
        userBean.setUsername((String)map.get("username"));
        userBean.setAnnoyname((String)map.get("annoyname"));
        userBean.setUserpwd((String)map.get("userpwd"));
        userService.regist(userBean);

    }



}
