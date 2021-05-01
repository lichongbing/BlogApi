package com.lichongbing.blogapi.mapper;

import com.lichongbing.blogapi.entify.PostAttribute;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostAttributeMapperTest {
    @Resource
    private PostAttributeMapper postAttributeMapper;
    @Test
    public void test() {
        Integer id=91;
        PostAttribute postAttribute = postAttributeMapper.selectById(id);
        String content = postAttribute.getContent();
//        return content;
     //   System.out.println(content);
        List<PostAttribute> postAttributes = postAttributeMapper.selectList(null);

        PostAttribute postAttribute1 = postAttributes.get(112);
        System.out.println(postAttribute1.getContent());
    }


}