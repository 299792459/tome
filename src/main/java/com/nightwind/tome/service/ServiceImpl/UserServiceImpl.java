package com.nightwind.tome.service.ServiceImpl;

import com.nightwind.tome.bean.UserBean;
import com.nightwind.tome.mapper.UserMapper;
import com.nightwind.tome.service.UserService;

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

    @Override
    public int getPwd(UserBean userBean) {
        return userMapper.getPwd(userBean);
    }

    @Override
    public int checkUserName(UserBean userBean) {
        return userMapper.checkUserName(userBean);
    }

    @Override
    public int getIdByUserName(String username) {
        return userMapper.getIdByUserName(username);
    }

    @Override
    public void regist(UserBean userBean) {
        userMapper.regist(userBean);
    }

}
