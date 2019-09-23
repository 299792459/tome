package com.nightwind.tome.service.ServiceImpl;

import com.nightwind.tome.bean.getAllCommentsByLetterIdBean;
import com.nightwind.tome.mapper.UserMapper;
import com.nightwind.tome.service.CommentService;
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
    UserMapper userMapper;
    @Override
    public List<getAllCommentsByLetterIdBean> getAllCommentsByLetterId(int replyletterid) {
        List<CommentBean> list=commentMapper.getAllCommentsByLetterId(replyletterid);
        List<getAllCommentsByLetterIdBean> listnew=null;
        for(int i=0;i<list.size();i++)
        {
            listnew.get(i).setCommentcontent(list.get(i).getCommentcontent());
            listnew.get(i).setCommenttime(list.get(i).getCommenttime());
            listnew.get(i).setReplyannoyname(userMapper.getUserByUserId(list.get(i).getReplyuserid()).get(0).getAnnoyname());
            listnew.get(i).setAnnoyname(userMapper.getUserByUserId(list.get(i).getUserid()).get(0).getAnnoyname());
        }

        return listnew;
    }


    @Override
    public void addComment(CommentBean commentBean) {


        commentMapper.addComment(commentBean);
    }
}
