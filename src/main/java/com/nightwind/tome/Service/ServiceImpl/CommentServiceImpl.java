package com.nightwind.tome.Service.ServiceImpl;

import com.nightwind.tome.Service.CommentService;
import com.nightwind.tome.bean.CommentBean;
import com.nightwind.tome.mapper.CommentMapper;
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
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<CommentBean> getAllcommentsbyLetterId(int letterid) {
        return commentMapper.getAllcommentsbyLetterId(letterid);
    }

    @Override
    public void addComment(CommentBean commentBean) {
        commentMapper.addComment(commentBean);
    }
}
