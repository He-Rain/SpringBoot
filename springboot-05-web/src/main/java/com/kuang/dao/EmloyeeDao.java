package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EmloyeeDao
 * @Author 何雨铭
 * @Date 2022/11/17 10:59
 */
//好好学习，走向巅峰！
//    员工Dao
@Repository //注册到IOC容器中
public class EmloyeeDao {
     //员工所属部门
     public static Map<Integer, Employee> emloyees=null;
@Autowired
    private DepartmentDao departmentDao;

    static{
        emloyees=new HashMap<>();//创建一个员工表
        emloyees.put(1001,new Employee(1001,"AA","2879304849@qq.com",0,new Department(101,"教学部")));
        emloyees.put(1002,new Employee(1002,"BB","2879304849@qq.com",1,new Department(102,"市场部")));
        emloyees.put(1003,new Employee(1003,"CC","2879304849@qq.com",0,new Department(103,"教研部")));
        emloyees.put(1004,new Employee(1004,"DD","2879304849@qq.com",1,new Department(104,"运营部")));
        emloyees.put(1005,new Employee(1005,"EE","2879304849@qq.com",0,new Department(105,"后勤部")));
    }
//主键自增
    private static Integer initId=1006;
//    增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
    employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        emloyees.put(employee.getId(),employee);
    }
//    查询全部员工信息
    public Collection<Employee> getAll(){
        return emloyees.values();
    }
//    通过id查询员工
    public Employee getEmployeeById(Integer id){
        return emloyees.get(id);
    }
//    删除员工通过id
    public void delete(Integer id){
        emloyees.remove(id);
    }
}
