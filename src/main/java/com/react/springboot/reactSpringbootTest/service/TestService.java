package com.react.springboot.reactSpringbootTest.service;

import com.react.springboot.reactSpringbootTest.model.TestModel;

import java.util.List;
import java.util.Map;

public interface TestService {
    public List<TestModel> getAllSelect();

    public TestModel detailSelect(TestModel testModel);

    public int update(Map<String, Object> map);
    public int delete(Map<String, Object> map);
}

