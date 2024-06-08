package com.dcp.mapper;


import com.dcp.entity.Student;
import com.dcp.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

@Mapper
public interface DcpMapper {
    @Select("select * from student")
    List<Student> get();

    User login(String id);

    @Insert("insert into user (name,username,password,phone,sex,create_time,update_time,status)"+
            "values"+
            "(#{name},#{username},#{password},#{phone},#{sex},#{createTime},#{updateTime},#{status})")
    void insert(User user);
}
