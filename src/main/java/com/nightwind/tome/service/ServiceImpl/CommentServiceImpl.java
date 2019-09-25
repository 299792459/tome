package com.nightwind.tome.service.ServiceImpl;

import com.nightwind.tome.bean.UserBean;
import com.nightwind.tome.bean.getAllCommentsByLetterIdBean;
import com.nightwind.tome.mapper.UserMapper;
import com.nightwind.tome.service.CommentService;
import com.nightwind.tome.bean.CommentBean;
import com.nightwind.tome.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    UserMapper userMapper;

    @Override
    public List<getAllCommentsByLetterIdBean> getAllCommentsByLetterId(int replyletterid) {


        //得到一个id对应的评论实体的列表
        List<CommentBean> list = commentMapper.getAllCommentsByLetterId(replyletterid);
        //创建要返回的实体类
        List<getAllCommentsByLetterIdBean> listnew = new ArrayList<>();

        //这里是拼接返回值对象，放到list里面
        for (int i = 0; i < list.size(); i++) {
            getAllCommentsByLetterIdBean getAllCommentsByLetterIdBean = new getAllCommentsByLetterIdBean();
            listnew.add(getAllCommentsByLetterIdBean);
        }

        for (int j = 0; j < list.size(); j++) {
            getAllCommentsByLetterIdBean gb1=listnew.get(j);

            gb1.setReplyuserid(list.get(j).getReplyuserid());
            gb1.setCommentid(list.get(j).getCommentid());
            gb1.setCommentcontent(list.get(j).getCommentcontent());
            gb1.setCommenttime(list.get(j).getCommenttime());

            //评论实体
            CommentBean cb2=list.get(j);
            //userid
            int usid=cb2.getUserid();
            //得到user实体
            UserBean u1=userMapper.getOneUserByUserId(usid);
            System.out.println(u1.getAnnoyname());
            //昵称
            String anname=u1.getAnnoyname();
            //设置值
            gb1.setAnnoyname("test");





            //评论实体
            CommentBean commentBean=list.get(j);
            //得到回复的userid
            int replyuseridid=commentBean.getReplyuserid();
            //通过id查到user实体，然后
            UserBean userBean=userMapper.getOneUserByUserId(replyuseridid);
            //user实体调用get昵称
            String annoyname=userBean.getAnnoyname();
            //设置值
            gb1.setReplyannoyname(annoyname);


        }


        return listnew;
    }


    @Override
    public void addComment(CommentBean commentBean) {


        commentMapper.addComment(commentBean);
    }
}
