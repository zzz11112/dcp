package com.dcp.controller;

import com.dcp.entity.Student;
import com.dcp.result.Result;
import com.dcp.service.DcpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DcpController {
    @Autowired
    private DcpService dcpService;

    @GetMapping("/get")
    public Result<List> get() {
        log.info("查询所有学生信息,{}");
        List<Student> students = dcpService.get();

        return Result.success(students);
    }
}
