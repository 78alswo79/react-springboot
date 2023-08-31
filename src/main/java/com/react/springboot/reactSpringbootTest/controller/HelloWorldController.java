package com.react.springboot.reactSpringbootTest.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.react.springboot.reactSpringbootTest.service.TestServiceImpl;
import jakarta.annotation.PostConstruct;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import com.react.springboot.reactSpringbootTest.model.TestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class HelloWorldController {

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

    @GetMapping("/api/{gbn}")
    public Map<String, String> update(@RequestParam Map<String,Object> params, @PathVariable String gbn)  {

        System.out.println(gbn);
        System.out.println("통신 성공@!"+params);
        Map<String,String> resMessage = new HashMap<>();

        // 업데이트/삭제 성공여부. 0 : 실팰, 1 : 성공
        int result = 0;

        // gbn 업데이트
        if (gbn.equals("update")) {
            result = testServiceImpl.update(params);

            if (result == 0) {
                resMessage.put("val", "0");
                resMessage.put("message", "업데이트가 실패했습니다.");
            } else {
                resMessage.put("val", "1");
                resMessage.put("message", "업데이트가 성공했습니다.");
            }

        } else {
        // gbn delete
            result = testServiceImpl.delete(params);

            if (result == 0) {
                resMessage.put("val", "0");
                resMessage.put("message", "삭제가 실패했습니다.");
            } else {
                resMessage.put("val", "1");
                resMessage.put("message", "삭제가 성공했습니다.");
            }
        }
        return resMessage;
    }
}
