package com.nightwind.tome;

import com.nightwind.tome.bean.getAllCommentsByLetterIdBean;
import com.nightwind.tome.mapper.UserMapper;
import com.nightwind.tome.service.CommentService;
import com.nightwind.tome.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TomeApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @Test
    public void contextLoads() {

    }

    @Test
    //点击查询此url下所有留言对应的评论
    @RequestMapping(value = "/getAllCommentsbyLetterId")
    @ResponseBody
    public void getAllCommentsbyLetterId()
    {

        Map map=null;

        //List<Integer> lettersidlist=letterService.getLettersIdByUrl(currenturl);.intValue()
        List lettersidlist=new ArrayList();
        lettersidlist.add(1);
        int leti;
        for(int i=0;i<lettersidlist.size();i++)
        {
            leti=(int)lettersidlist.get(i);
            System.out.println(leti);
            map.put(i+"",commentService.getAllCommentsByLetterId(1));
            System.out.println(map.get(i+""));
        }

        //return map;
    }

}
