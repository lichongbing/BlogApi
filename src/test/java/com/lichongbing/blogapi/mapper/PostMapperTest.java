package com.lichongbing.blogapi.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lichongbing.blogapi.entify.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostMapperTest {
    @Resource
    private PostMapper postMapper;

    @Test
    public void testSelectPost() {
        Page<Post> page = new Page<>(1, 100);
        page.addOrder(OrderItem.desc("created"));
        Page<Post> postPage = postMapper.selectPage(page, null);
        System.out.println("总条数：" + postPage.getTotal());
        System.out.println("当前页数：" + postPage.getCurrent());
        System.out.println("每页大小：" + postPage.getSize());
        System.out.println("当页大小：" + postPage.getRecords().size());
        System.out.println(postPage.getRecords());

    }
    @Test
    public  void filterSelectPost() {
        Page<Post> page = new Page<>(1, 100);
        page.addOrder(OrderItem.desc("created"));
        QueryWrapper<Post> queryWrapper = new QueryWrapper();
        queryWrapper.like("channel_id","22");
        Page<Post> postPage = postMapper.selectPage(page, queryWrapper);
        System.out.println("总条数：" + postPage.getTotal());
        System.out.println("当前页数：" + postPage.getCurrent());
        System.out.println("每页大小：" + postPage.getSize());
        System.out.println("当页大小：" + postPage.getRecords().size());
        System.out.println(postPage.getRecords());
    }


}