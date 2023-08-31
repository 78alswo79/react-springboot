package com.react.springboot.reactSpringbootTest.mapper;

import com.react.springboot.reactSpringbootTest.model.MemberModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
    int getMemberCheck (MemberModel member);
}
