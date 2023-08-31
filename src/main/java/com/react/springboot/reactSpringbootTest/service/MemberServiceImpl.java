package com.react.springboot.reactSpringbootTest.service;

import com.react.springboot.reactSpringbootTest.mapper.MemberMapper;
import com.react.springboot.reactSpringbootTest.model.MemberModel;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements  MemberService{

    private MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public int getMemberCheck(MemberModel member) {

        return memberMapper.getMemberCheck(member);
//        return memberMapper.getMemberCheck(member);
    }
}
