package com.lichongbing.blogapi.data.service.impl;

import com.lichongbing.blogapi.data.dao.GirlDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.lichongbing.blogapi.data.service.GirlService;
import org.springframework.stereotype.Service;

/**
 * 服务接口实现
 *
 * @author lichongbing
 * @since 2021-05-03 20:18:21
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class GirlServiceImpl implements GirlService {
    private final GirlDao girlDao;

}