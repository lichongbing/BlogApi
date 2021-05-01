package com.lichongbing.blogapi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lichongbing.blogapi.entify.Post;
import com.lichongbing.blogapi.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostService {

    @Resource
    private PostMapper postMapper;
    private Integer size=40;


    public Page slectPost(Integer pageN) {

        Page<Post> page = new Page<>(pageN, size);
        page.addOrder(OrderItem.desc("created"));
        Page<Post> postPage = postMapper.selectPage(page, null);
        System.out.println(postPage.getRecords());
        return postPage;

    }

    public Page filterPost(Integer pageN,Integer channelId) {
        Page<Post> page = new Page<>(pageN, size);
        page.addOrder(OrderItem.desc("created"));
        QueryWrapper<Post> queryWrapper = new QueryWrapper();
        queryWrapper.like("channel_id",channelId);
        Page<Post> postPage = postMapper.selectPage(page, queryWrapper);
        System.out.println(postPage.getRecords());
        return postPage;
    }

    public  List<Post> getAllPost() {

        return postMapper.selectList(null);

    }



}
