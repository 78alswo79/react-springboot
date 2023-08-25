package com.react.springboot.reactSpringbootTest.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.react.springboot.reactSpringbootTest.model.TestModel;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface  TestMapper {

//    @Select("SELECT * FROM test")
    List<TestModel> allSelect();
    TestModel detailSelect(TestModel testModel);


}
