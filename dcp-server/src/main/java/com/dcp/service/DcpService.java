package com.dcp.service;

import com.dcp.DTO.UserLoginDTO;
import com.dcp.DTO.UserSignupDTO;
import com.dcp.entity.Student;
import com.dcp.entity.User;

import java.util.List;

public interface DcpService {
    List<Student> get();

    User login(UserLoginDTO userDTO);

    void signup(UserSignupDTO userSignupDTO);
}
