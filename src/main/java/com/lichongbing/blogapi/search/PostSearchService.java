package com.lichongbing.blogapi.search;

import com.lichongbing.blogapi.vo.PostRearchVo;

import java.io.IOException;
import java.util.List;

public interface PostSearchService {

    boolean importAll() throws IOException;
    boolean addPostRearchVo(PostRearchVo postRearchVo, String id) throws IOException;

    List<PostRearchVo> searchMatch(String key, String value) throws IOException;

    List<PostRearchVo> searchTerm(String key,String value) throws IOException;

    List<PostRearchVo> searchMatchPrefix(String key,String value) throws IOException;
}
