package com.kuang.controller;

import com.kuang.dao.DepartmentDao;
import com.kuang.dao.EmloyeeDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @ClassName EmployeeController
 * @Author 何雨铭
 * @Date 2022/11/20 14:45
 */
//好好学习，走向巅峰！
@Controller
public class EmployeeController {
       @Autowired
        EmloyeeDao emloyeeDao;
    @Autowired
       DepartmentDao departmentDao;
       @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=emloyeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
//    去员工添加的页面
@GetMapping("/emp")
    public String toAddpage(Model model){
//         查出所有部门信息
           Collection<Department> departments=departmentDao.getDepartments();
           model.addAttribute("departments",departments);
           return    "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
//      添加用户操作
        System.out.println("debug==>"+employee);
        emloyeeDao.save(employee); //调用底层业务方法保存员工信息
        return    "redirect:emps";
    }
//去员工的修改页面
    @GetMapping("/emp/{id}")
 public  String   toUpdate(@PathVariable("id") Integer id,Model model){
//           查出原来的数据
        Employee employee=emloyeeDao.getEmployeeById(id);
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("emp",employee);
        return "emp/update";

 }
 //员工信息修改
   @PostMapping ("/updateEmp")
    public  String updateEmp(Employee employee){
        System.out.println("debug==>"+employee);
        emloyeeDao.save(employee); //调用底层业务方法保存员工信息
           return "redirect:/emps";
    }
//    删除员工
@GetMapping("/delemp")
    public String deletemp( Integer id){
          emloyeeDao.delete(id);
           return "redirect:/emps";
    }
}
