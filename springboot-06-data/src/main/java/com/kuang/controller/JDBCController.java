package com.kuang.controller;

import  org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JDBCController
 * @Author 何雨铭
 * @Date 2022/11/22 20:13
 */
//好好学习，走向巅峰！
    @RestController
public class JDBCController {
       @Resource
        JdbcTemplate jdbcTemplate;
    //.查询数据库的所有信息
 //没有实体类，数据库中的东西，怎么获取? 通过Map
@GetMapping("/userList")
    public List<Map<String,Object>> userList(){
       String sql="select * from user";
     List<Map<String,Object>> list_map=jdbcTemplate.queryForList(sql);
        return list_map;
    }
    @GetMapping("/addUser")
    public String addUser(){
    String sql="insert into mybatis.user(id,name,pwd)value(6,'小明','123456')";
    jdbcTemplate.update(sql);
    return  "save";
    }
    @GetMapping("/updateUser")
    public String updateUser( int id){
String sql="update user set name=?,pwd=? where id="+id;
//封装
        Object[] objects=new Object[2];
        objects[0]="小明2";
        objects[1]="zzzzzzz";
        jdbcTemplate.update(sql, objects);
        return "update";
    }
//    非RESTful传参风格
@GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
    String sql="delete from user where id=?";
    jdbcTemplate.update(sql,id);
    return "delete";
    }
}
