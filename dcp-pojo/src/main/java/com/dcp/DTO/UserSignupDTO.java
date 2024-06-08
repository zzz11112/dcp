package com.dcp.DTO;

import lombok.Data;

@Data
public class UserSignupDTO {
    private String username;
    private String name;
    private String password;
    private String phone;
    private String sex;

}
