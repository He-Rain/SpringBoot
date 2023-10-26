package com.kfm.controller;


import com.kfm.entity.BlogPojo;
import com.kfm.entity.UserPojo;
import com.kfm.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/blog")
public class BlogController {
   @Autowired
    private BlogService blogService;
   //发布博客
   @RequestMapping("/send")
    public String sendBlog(BlogPojo blogpojo, Model model){
       int i = blogService.sendBlog(blogpojo);
       if(i > 0){
           model.addAttribute("msg","发布成功！");
       }else{
           model.addAttribute("msg","请重新发布！");
       }
       return "index";
   }
   //查询所有博客
    @RequestMapping("/select")
    public String selectBlogByUsername(String username,Model model){
        UserPojo userPojo = blogService.selectBlogByUsername(username);
        if(userPojo != null){
            model.addAttribute("userPojo",userPojo);
        }else{
            model.addAttribute("msg","请先发布博客");
        }
        return "index";
    }
    //根据bid查询博客
    @RequestMapping("/selectone")
    public String selectBlogById(int bid,Model model){
       BlogPojo blogPojo = blogService.selectBlogById(bid);
       if(blogPojo != null){
           model.addAttribute("blogPojo",blogPojo);
           return "update";
       }else{
           model.addAttribute("msg","请先发布！");
           return "index";
       }
    }
    //修改博客
    @RequestMapping("/update")
    public String updateBlogById(BlogPojo blogPojo,Model model){
       int i = blogService.updateBlogById(blogPojo);
       if(i > 0){
           //重定向到查询
           //return "redirect:/blog/select";
           model.addAttribute("msg","修改成功！");
           return "index";
       }else{
           model.addAttribute("msg","修改失败！");
           return "index";
       }
    }
    //删除博客
    @RequestMapping("/delete")
    public String deleteBlogById(int bid,Model model){
      int i = blogService.deleteBlogById(bid);
      if(i > 0){
          model.addAttribute("msg","删除成功！");
      }else{
          model.addAttribute("msg","删除失败！");
      }
      //return "redirect:/blog/delete";重定向
       return "index";
    }
}
