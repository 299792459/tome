package com.nightwind.tome.service;

import com.nightwind.tome.bean.UserBean;
import com.nightwind.tome.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈和用户有关的服务〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
@Service
public interface UserService {

    //通过id查询user
    List<UserBean> getUserByUserId(int userid);

    //通过username查询user
    String isUsernameExisted(String username);
    //注册新用户
    void addUser(UserBean userBean);

    //登录
    UserBean login(String username,String userpwd);
}
