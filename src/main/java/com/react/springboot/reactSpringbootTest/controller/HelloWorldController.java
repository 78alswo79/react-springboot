package com.react.springboot.reactSpringbootTest.controller;

import com.react.springboot.reactSpringbootTest.service.TestServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.react.springboot.reactSpringbootTest.model.TestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloWorldController {
//    @GetMapping("/api/hello")
//    public String test() {
//        return "Hello, world!!";
//    }

//    @Autowired
    private TestServiceImpl testServiceImpl;

    public HelloWorldController(TestServiceImpl testServiceImpl) {
        this.testServiceImpl = testServiceImpl;
    }


    @GetMapping("/api/test")
    public Map<String, Object> testHandler() {

        Map<String, Object> res = new HashMap<>();
        res.put("SUCCESS", true);
        res.put("SUCCESS_TEXT", "Hello SpringBoot/React");

        return res;
    }

    // Home화면 데이터
    @GetMapping("/api/selectTest")
    public List<TestModel> selectT() {
        List<TestModel> allList = new ArrayList<>();

        allList = testServiceImpl.getAllSelect();
        System.out.println(allList);

        return allList;
    }

    // detail화면 데이터
    @GetMapping("/api/detail/{gimozzi}")
    public TestModel getDetail(@PathVariable("gimozzi") int gimozzi) {
        TestModel testModel = new TestModel();
        testModel.setId(gimozzi);

        List<TestModel> detailList = new ArrayList<>();
        System.out.println(testServiceImpl.detailSelect(testModel));
        return testServiceImpl.detailSelect(testModel);
    }

}
