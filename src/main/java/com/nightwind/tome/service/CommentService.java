package com.nightwind.tome.service;

import com.nightwind.tome.bean.CommentBean;
import com.nightwind.tome.bean.getAllCommentsByLetterIdBean;
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
public interface CommentService {

    List<getAllCommentsByLetterIdBean> getAllCommentsByLetterId(int replyletterid);
    void addComment(CommentBean commentBean);

}
