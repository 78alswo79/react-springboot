package com.react.springboot.reactSpringbootTest.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.react.springboot.reactSpringbootTest.mapper.TestMapper;
import com.react.springboot.reactSpringbootTest.model.TestModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestServiceImpl implements TestService {

    private TestMapper testMapper;

    public TestServiceImpl(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @Override
    public List<TestModel> getAllSelect() {

        List<TestModel> ll = new ArrayList<TestModel>();
        ll = testMapper.allSelect();
        return ll;
    }

    @Override
    public TestModel detailSelect(TestModel testModel) {
        List<TestModel> ll = new ArrayList<TestModel>();
        return testMapper.detailSelect(testModel);
    }

    @Override
    public int update(Map<String, Object> map) {
        Map<String, Object> obj = new HashMap<String, Object>();

        // front-end에서 넘어온 JSON데이터
        JSONObject object = new JSONObject(map);

        // JSON안에 []값을 초기화
        JSONArray jArray2 = new JSONArray(object.getString("id"));

        int[] intArr = new int[jArray2.length()];

        for (int i = 0; i < jArray2.length(); i++) {
            intArr[i] = Integer.parseInt(jArray2.getString(i));
        }
        obj.put("objId", intArr);
        obj.put("objText", map.get("text"));

        return testMapper.update(obj);
    }

    @Override
    public int delete(Map<String, Object> map) {
        Map<String, Object> obj = new HashMap<String, Object>();

        // front-end에서 넘어온 JSON데이터
        JSONObject object = new JSONObject(map);

        // JSON안에 []값을 초기화
        JSONArray jArray2 = new JSONArray(object.getString("id"));

        int[] intArr = new int[jArray2.length()];

        for (int i = 0; i < jArray2.length(); i++) {
            intArr[i] = Integer.parseInt(jArray2.getString(i));
        }
        obj.put("objId", intArr);

        return testMapper.delete(obj);
    }
}
