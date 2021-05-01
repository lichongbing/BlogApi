package com.lichongbing.blogapi.service;

import com.alibaba.fastjson.JSONObject;
import com.lichongbing.blogapi.search.PostSearchService;
import com.lichongbing.blogapi.vo.PostRearchVo;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class PostSearchServiceImpl implements PostSearchService {

    @Resource
    private RestHighLevelClient client;

    @Resource
    private PostRearchVoService postRearchVoService;


    private static final String NBA_INDEX = "nba_v1";

    private static final int START_OFFSET = 0;

    private static final int MAX_COUNT = 20;


    @Override
    public boolean importAll() throws IOException {

        List<PostRearchVo> allpostRearchVo = postRearchVoService.getAllpostRearchVo();
        int count = 1;
        for (PostRearchVo newAllpostRearchVo : allpostRearchVo
        ) {
            addPostRearchVo(newAllpostRearchVo, String.valueOf(newAllpostRearchVo.getId()));
            System.out.println("importAll {} : {}" + newAllpostRearchVo + count++);
        }

        return true;
    }

    @Override
    public boolean addPostRearchVo(PostRearchVo postRearchVo, String id) throws IOException {

        IndexRequest request = new IndexRequest(NBA_INDEX).id(id).source(beanToMap(postRearchVo));
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println("addPostRearchVo {}" + response.toString());

        return true;
    }

    @Override
    public List<PostRearchVo> searchMatch(String key, String value) throws IOException {

        SearchRequest searchRequest = new SearchRequest(NBA_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery(key, value));
        searchSourceBuilder.from(START_OFFSET);
        searchSourceBuilder.size(MAX_COUNT);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSONObject.toJSON(response));
        SearchHit[] hits = response.getHits().getHits();
        List<PostRearchVo> postRearchVoList = new LinkedList<>();
        for (SearchHit hit : hits) {
            PostRearchVo postRearchVo = JSONObject.parseObject(hit.getSourceAsString(), PostRearchVo.class);
            postRearchVoList.add(postRearchVo);
        }
        return postRearchVoList;

    }

    @Override
    public List<PostRearchVo> searchTerm(String key, String value) throws IOException {

        SearchRequest searchRequest = new SearchRequest(NBA_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery(key,value));
        searchSourceBuilder.from(START_OFFSET);
        searchSourceBuilder.size(MAX_COUNT);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest,RequestOptions.DEFAULT);
        System.out.println(JSONObject.toJSON(response));
        SearchHit[] hits = response.getHits().getHits();
        List<PostRearchVo> postRearchVoList = new LinkedList<>();
        for (SearchHit hit : hits) {
            PostRearchVo postRearchVo = JSONObject.parseObject(hit.getSourceAsString(), PostRearchVo.class);
            postRearchVoList.add(postRearchVo);
        }
        return postRearchVoList;
    }

    @Override
    public List<PostRearchVo> searchMatchPrefix(String key, String value) throws IOException {

        SearchRequest searchRequest = new SearchRequest(NBA_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.prefixQuery(key,value));
        searchSourceBuilder.from(START_OFFSET);
        searchSourceBuilder.size(MAX_COUNT);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest,RequestOptions.DEFAULT);
        System.out.println(JSONObject.toJSON(response));
        SearchHit[] hits = response.getHits().getHits();
        List<PostRearchVo> postRearchVoList = new LinkedList<>();
        for (SearchHit hit : hits) {
            PostRearchVo postRearchVo = JSONObject.parseObject(hit.getSourceAsString(), PostRearchVo.class);
            postRearchVoList.add(postRearchVo);
        }
        return postRearchVoList;
    }
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                if (beanMap.get(key) != null)
                    map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }
}
