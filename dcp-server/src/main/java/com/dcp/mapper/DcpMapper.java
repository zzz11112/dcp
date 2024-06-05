package com.dcp.mapper;

import com.dcp.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DcpMapper {
    @Select("select * from student")
    List<Student> get();
}
