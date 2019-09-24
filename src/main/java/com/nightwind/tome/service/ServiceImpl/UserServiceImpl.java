package com.nightwind.tome.service.ServiceImpl;

import com.nightwind.tome.bean.UserBean;
import com.nightwind.tome.mapper.UserMapper;
import com.nightwind.tome.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserBean> getUserByUserId(int userid) {
        return userMapper.getUserByUserId(userid);
    }

    //public String addUser(UserBean userBean){
    //}

    //通过username查询user
    public String isUsernameExisted(String username){

        if(userMapper.isUsernameExisted(username).isEmpty())
        {
            return "notexisted";
        }

        return "isexisted";
    }

    @Override
    public void addUser(UserBean userBean) {

    }

    //登录
    public UserBean login(@Param("username") String username, @Param("userpwd") String userpwd){

        //在客户端判断，如果为空则是登陆失败，不为空则把整个值存储起来。
        return userMapper.login(username,userpwd);
    }
}
