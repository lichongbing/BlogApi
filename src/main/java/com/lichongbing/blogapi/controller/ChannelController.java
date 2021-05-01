package com.lichongbing.blogapi.controller;

import com.lichongbing.blogapi.entify.Channel;
import com.lichongbing.blogapi.service.ChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "专题分类信息")
@RestController
public class ChannelController {
    
    @Autowired
    ChannelService channelService;
    @ApiOperation("获取所有专题分类信息")
    @RequestMapping(value = "/channel",method = RequestMethod.GET)
    public List<Channel> requestChannel() {
       return channelService.getAllChannels();
    }
    
}
