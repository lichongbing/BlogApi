package com.lichongbing.blogapi.controller;

import com.lichongbing.blogapi.result.ExceptionMsg;
import com.lichongbing.blogapi.result.ResponseData;
import com.lichongbing.blogapi.service.PostAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "文章内容")
@RestController
@RequestMapping("/content")
public class PostAttributeController {
    @Autowired
    PostAttributeService postAttributeService;
    @ApiOperation("通过主键查询文章内容")
    @GetMapping("{id}")
    public ResponseData getContent(@PathVariable Integer id) {
        String content = postAttributeService.getPostContent(id);
        return new ResponseData(ExceptionMsg.SUCCESS,content);
    }
}
