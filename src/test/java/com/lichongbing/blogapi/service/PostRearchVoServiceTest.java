package com.lichongbing.blogapi.service;

import com.lichongbing.blogapi.entify.Post;
import com.lichongbing.blogapi.entify.PostAttribute;
import com.lichongbing.blogapi.vo.PostRearchVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRearchVoServiceTest {


    @Resource
    PostService postService;
    @Resource
    PostAttributeService postAttributeService;

    @Test
    public void postRearchVo() {

        List<Post> allPost = postService.getAllPost();
       // System.out.println(allPost);
        List<PostAttribute> allPostAttribute = postAttributeService.getAllPostAttribute();
      //  System.out.println(allPostAttribute);
        List<PostRearchVo> postRearchVos = new ArrayList<PostRearchVo>();
        for (int i = 0;i <allPost.size(); i++) {
            PostRearchVo postRearchVo = new PostRearchVo();
            Post post = allPost.get(i);
            long id = post.getId();
            String summary = post.getSummary();
            String title = post.getTitle();
            postRearchVo.setId(id);
            postRearchVo.setSummary(summary);
            postRearchVo.setTitle(title);
            PostAttribute postAttribute = allPostAttribute.get(i);
            String content = postAttribute.getContent();
            postRearchVo.setContent(content);
            postRearchVos.add(postRearchVo);
        }
        System.out.println(postRearchVos);


    }
}