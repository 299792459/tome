package com.nightwind.tome.Service;

import com.nightwind.tome.bean.CommentBean;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 陈景
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
public interface CommentService {

    List<CommentBean> getAllcommentsbyLetterId(int letterid);
    void addComment(CommentBean commentBean);
}
