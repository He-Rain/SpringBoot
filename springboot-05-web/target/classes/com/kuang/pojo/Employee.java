package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Department
 * @Author 何雨铭
 * @Date 2022/11/15 23:07
 */
//好好学习，走向巅峰！
    //员工表

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;//0:女 1:男
    private Department department;
    private Date date;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认地创建日期
      this.date=new Date();
    }
    //
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getId() {
//        return id;
//    }
}
