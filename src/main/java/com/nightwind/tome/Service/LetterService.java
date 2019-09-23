package com.nightwind.tome.Service;

import com.nightwind.tome.bean.CommentBean;
import com.nightwind.tome.bean.LetterBean;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈评论的服务接口〉
 *
 * @author 陈景
 * @create 2019/9/19 0019
 * @since StaticConfigParam.0.0
 */
@Service
public interface LetterService {
    List<LetterBean> getAllLettersByurl(String url);

    void addLetter(LetterBean letterBean);
}