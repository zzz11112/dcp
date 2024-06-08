package com.dcp.service.impl;


import com.dcp.DTO.UserLoginDTO;
import com.dcp.DTO.UserSignupDTO;
import com.dcp.constant.MessageConstant;
import com.dcp.constant.StatusConstant;
import com.dcp.entity.Student;
import com.dcp.entity.User;
import com.dcp.exception.AccountNotFoundException;
import com.dcp.exception.PasswordErrorException;
import com.dcp.mapper.DcpMapper;
import com.dcp.service.DcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
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

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        User user = dcpMapper.login(username);
        // user为空：用户不存在
        if (user == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //password错误
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        return user;
    }

    @Override
    public void signup(UserSignupDTO userSignupDTO) {
        //BeanUtils.copyProperties(userSignupDTO,user);
        User user = User.builder()
                .username(userSignupDTO.getUsername())
                .name(userSignupDTO.getName())
                .password(DigestUtils.md5DigestAsHex(userSignupDTO.getPassword().getBytes()))
                .phone(userSignupDTO.getPhone())
                .sex(userSignupDTO.getSex())
                .status(StatusConstant.ENABLE)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        dcpMapper.insert(user);
    }


}
