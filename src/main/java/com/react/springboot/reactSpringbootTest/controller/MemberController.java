package com.react.springboot.reactSpringbootTest.controller;

import com.react.springboot.reactSpringbootTest.model.MemberModel;
import com.react.springboot.reactSpringbootTest.service.MemberServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class MemberController {

    private MemberServiceImpl memberServiceImpl;

    public MemberController(MemberServiceImpl memberServiceImpl) {
        this.memberServiceImpl = memberServiceImpl;
    }

    @PostMapping("/request")
    public Map<String,Object> loginRequest(MemberModel member) {
        System.out.println(member);

        int selectRes = memberServiceImpl.getMemberCheck(member);
        Map<String,Object> res = new HashMap<>();
        // selectRes 1 : 회원정보 있음, 0 : 회원정보 없음.
        if (selectRes > 0) {
            res.put("flag", 1);
            res.put("message", "로그인 되었습니다. 환영합니다.");
        } else {
            res.put("flag", 0);
            res.put("message", "회원정보가 일치하지 않습니다. 다시 확인 바랍니다.");
        }
        return res;
    }
}
