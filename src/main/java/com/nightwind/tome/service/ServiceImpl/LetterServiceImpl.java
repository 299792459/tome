package com.nightwind.tome.service.ServiceImpl;


import com.nightwind.tome.bean.getAllLettersByUrlBean;
import com.nightwind.tome.mapper.LetterMapper;
import com.nightwind.tome.service.LetterService;
import com.nightwind.tome.bean.LetterBean;
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
public class LetterServiceImpl implements LetterService {

    //注入mapper
    @Autowired
    private LetterMapper letterMapper;



    @Override
    public List<getAllLettersByUrlBean> getAllLettersByurl(String url) {

        return letterMapper.getAllLettersByUrl(url);
    }

    @Override
    public void addLetter(LetterBean letterBean) {
        letterMapper.addLetter(letterBean);
    }

    public List<Integer> getLettersIdByUrl(String letterurl){

        return letterMapper.getLettersIdByUrl(letterurl);
    }

}
