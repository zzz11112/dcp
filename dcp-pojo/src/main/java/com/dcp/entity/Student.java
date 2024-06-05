package com.dcp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int number;
    private int grade;
    private int classNum;
}
