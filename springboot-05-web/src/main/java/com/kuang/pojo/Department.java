package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Department
 * @Author 何雨铭
 * @Date 2022/11/15 23:07
 */
//好好学习，走向巅峰！
//部门表
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;

}
