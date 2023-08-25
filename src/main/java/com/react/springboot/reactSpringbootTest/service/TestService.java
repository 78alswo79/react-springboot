package com.react.springboot.reactSpringbootTest.service;

import com.react.springboot.reactSpringbootTest.model.TestModel;

import java.util.List;

public interface TestService {
    public List<TestModel> getAllSelect();

    public TestModel detailSelect(TestModel testModel);
}
