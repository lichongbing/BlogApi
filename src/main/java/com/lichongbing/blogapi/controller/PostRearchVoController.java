package com.lichongbing.blogapi.controller;

import com.lichongbing.blogapi.result.ExceptionMsg;
import com.lichongbing.blogapi.result.ResponseData;
import com.lichongbing.blogapi.search.PostSearchService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import com.lichongbing.blogapi.service.PostSearchServiceImpl;
import com.lichongbing.blogapi.vo.PostRearchVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
@Api(tags = "搜索引擎")
@RestController
@RequestMapping("/search")
public class PostRearchVoController {
    @Autowired
    PostSearchService postSearchService;
    @ApiOperation("搜索引擎数据刷新")
    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public String getallPostRearchVo() {
        try {
            postSearchService.importAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
//    @ApiOperation("搜索文章内容")
//    @RequestMapping(value = "/content", method = RequestMethod.GET)
//    public List<PostRearchVo> searchMatchByDisplayNameEn(@RequestParam(value = "content", required = false) String content) {
//        try {
//            postSearchService.searchMatch("content", content);
//           // postSearchService.searchTerm("content", content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    @ApiOperation("检索文章内容")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public ResponseData searchTerm (@RequestParam(value = "title", required = false) String title,
                                    @RequestParam(value = "summary", required = false) String summary) {
        try {
            if(StringUtils.isNoneBlank(title)) {
                List<PostRearchVo> postRearchVoList = postSearchService.searchTerm("title", title);
           
            return new ResponseData(ExceptionMsg.SUCCESS,postRearchVoList);
            }
            else if(StringUtils.isNoneBlank(summary)) {
                List<PostRearchVo> postRearchVoList = postSearchService.searchTerm("summary", summary);

            return new ResponseData(ExceptionMsg.SUCCESS,postRearchVoList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @RequestMapping("/searchMatchPrefix")
//    public List<PostRearchVo> searchMatchPrefix(@RequestParam(value = "displayNameEn", required = false) String displayNameEn) {
//        try {
//            return postSearchService.searchMatchPrefix("displayNameEn",displayNameEn);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//
//    }
}
