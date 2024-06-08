package com.dcp.controller;

import com.dcp.DTO.UserLoginDTO;
import com.dcp.DTO.UserSignupDTO;
import com.dcp.VO.UserLoginVO;
import com.dcp.entity.Student;
import com.dcp.entity.User;
import com.dcp.result.Result;
import com.dcp.service.DcpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/dcp")
public class DcpController {
    @Autowired
    private DcpService dcpService;

    @GetMapping("/get")
    public Result<List> get() {
        log.info("查询所有学生信息,{}");
        List<Student> students = dcpService.get();
        return Result.success(students);
    }

    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("登录信息：{}",userLoginDTO);
        User user = dcpService.login(userLoginDTO);
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .username(user.getName())
                .name(user.getName())
                .build();
        return Result.success(userLoginVO);
    }

    @PutMapping
    public Result signup(@RequestBody UserSignupDTO userSignupDTO){
        log.info("注册信息：{}",userSignupDTO);
        dcpService.signup(userSignupDTO);
        return Result.success();
    }

}
