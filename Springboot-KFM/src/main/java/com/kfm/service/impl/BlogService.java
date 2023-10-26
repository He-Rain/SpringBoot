package com.kfm.service.impl;


import com.kfm.entity.BlogPojo;
import com.kfm.entity.UserPojo;
import com.kfm.mapper.BlogMapper;
import com.kfm.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogMapper blogMapper;
    //发布博客
    @Override
    public int sendBlog(BlogPojo blogPojo) {
            return blogMapper.sendBlog(blogPojo);
    }
    //查询博客
    @Override
    public UserPojo selectBlogByUsername(String username) {
        return blogMapper.selectBlogByUsername(username);
    }
    //根据bid查询博客
    @Override
    public BlogPojo selectBlogById(int bid) {
        return blogMapper.selectBlogById(bid);
    }
    //根据bid修改博客
    @Override
    public int updateBlogById(BlogPojo blogPojo) {
        return blogMapper.updateBlogById(blogPojo);
    }
    //删除博客
    @Override
    public int deleteBlogById(int bid) {
        return blogMapper.deleteBlogById(bid);
    }

}
