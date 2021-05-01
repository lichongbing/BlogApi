package com.lichongbing.blogapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lichongbing.blogapi.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@Api(tags = "文章信息")
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @ApiOperation("分页查询所有数据")
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public Object getPost(@RequestBody Map<String,String> postRequest) {
        Integer pageNo = Integer.valueOf(postRequest.get("pageNo"));
        return postService.slectPost(pageNo);
    }
    @ApiOperation("分页条件过滤查询所有数据")
    @RequestMapping(value = "/channel",method = RequestMethod.POST)
    public  Object getPostByChannelId(@RequestBody Map<String,String> postChannelRequest) {
        Integer pageNo = Integer.valueOf(postChannelRequest.get("pageNo"));
        Integer channelId = Integer.valueOf(postChannelRequest.get("channelId"));
        return postService.filterPost(pageNo,channelId);

    }

}
