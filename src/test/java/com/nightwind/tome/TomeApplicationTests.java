package com.nightwind.tome;

import com.nightwind.tome.bean.getAllCommentsByLetterIdBean;
import com.nightwind.tome.bean.getAllLettersByUrlBean;
import com.nightwind.tome.mapper.UserMapper;
import com.nightwind.tome.service.CommentService;
import com.nightwind.tome.service.LetterService;
import com.nightwind.tome.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TomeApplicationTests {

    @Test
    public void contextLoads() {

    }



}
