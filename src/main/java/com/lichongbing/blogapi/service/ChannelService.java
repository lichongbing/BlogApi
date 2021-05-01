package com.lichongbing.blogapi.service;

import com.lichongbing.blogapi.entify.Channel;
import com.lichongbing.blogapi.mapper.ChannelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChannelService {
    @Resource
    ChannelMapper channelMapper;
    public List<Channel> getAllChannels() {
        return channelMapper.selectList(null);
    }
}
