package com.kfm.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserPojo {
    private int uid;
    private String username;
    private String password;
    private List<BlogPojo> blogList;
}
