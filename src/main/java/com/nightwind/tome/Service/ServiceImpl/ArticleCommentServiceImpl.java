package com.nightwind.tome.Service.ServiceImpl;


import com.nightwind.tome.mapper.ArticleCommentMapper;
import com.nightwind.tome.Service.ArticleCommentService;
import com.nightwind.tome.bean.ArticleComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈评论服务接口的具体实现〉
 *
 * @author 陈景
 * @create 2019/9/19 0019
 * @since StaticConfigParam.0.0
 */
@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {

    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    @Override
    public List<ArticleComment> getArticleComment() {
        return articleCommentMapper.getAll();
    }

    @Override
    public void addArticleComment(ArticleComment articleComment) {
        articleCommentMapper.insert(articleComment);
    }
}
