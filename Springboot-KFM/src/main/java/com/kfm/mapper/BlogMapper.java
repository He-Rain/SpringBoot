package com.kfm.mapper;


import com.kfm.entity.BlogPojo;
import com.kfm.entity.UserPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {
    //发布
    public int sendBlog(BlogPojo blogPojo);
    //根据用户查询博客
    public UserPojo selectBlogByUsername(String username);
    //根据bid查询博客
    public BlogPojo selectBlogById(int id);
    //根据bid修改博客
    public int updateBlogById(BlogPojo blogPojo);
    //删除博客
    public int deleteBlogById(int bid);
}
