package com.nightwind.tome.service;

import com.nightwind.tome.bean.UserBean;
import org.apache.ibatis.annotations.Param;
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



     int getPwd(UserBean userBean);

     int checkUserName(UserBean userBean);

     int getIdByUserName(String username);

     void regist(UserBean userBean);

    UserBean getOneUserByUserId(int userid);
}
