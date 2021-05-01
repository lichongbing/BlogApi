package com.lichongbing.blogapi.mapper;

import com.lichongbing.blogapi.entify.Channel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChannelMapperTest {
    @Resource
    ChannelMapper channelMapper;
    @Test
    public  void testChannel() {

        List<Channel> channelList = channelMapper.selectList(null);
        Channel channel = channelList.get(0);
        String channelName = channel.getName();
        System.out.println(channelName);

    }


}