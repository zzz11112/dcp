package com.dcp.service.impl;

import com.dcp.entity.Student;
import com.dcp.mapper.DcpMapper;
import com.dcp.service.DcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DcpServiceImplement implements DcpService {
    @Autowired
    private DcpMapper dcpMapper;

    @Override
    public List<Student> get() {
        List<Student> students = dcpMapper.get();
        return students;
    }
}
