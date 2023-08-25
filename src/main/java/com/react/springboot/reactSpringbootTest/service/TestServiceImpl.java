package com.react.springboot.reactSpringbootTest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.react.springboot.reactSpringbootTest.mapper.TestMapper;
import com.react.springboot.reactSpringbootTest.model.TestModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
