package com.lichongbing.blogapi.service;

import com.lichongbing.blogapi.entify.PostAttribute;
import com.lichongbing.blogapi.mapper.PostAttributeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostAttributeService {
    @Resource
    private PostAttributeMapper postAttributeMapper;
    public String getPostContent(Integer id) {
        PostAttribute postAttribute = postAttributeMapper.selectById(id);
        String content = postAttribute.getContent();
        System.out.println(content);
        return content;
    }

    public List<PostAttribute> getAllPostAttribute() {

       return postAttributeMapper.selectList(null);

    }
}
