package com.zking.controller;

import com.jfinal.core.Controller;
import com.zking.Model.Student;

import java.util.List;

/**
 * @author: longyt
 * @create: 2018-01-18 15:28
 * @desc:
 **/
public class IndexController extends Controller {


   public void add(){
      Student student = Student.stu.findById("33");
      System.out.println(student.get("sid"));
      this.setSessionAttr("stu",student);
      renderJsp("/success.jsp");
   }

   public void addstudent(){
      Student person = getModel(Student.class,"studxzent");
      boolean f = person.save();
      System.out.println(f);
      if(f){
         renderText("add student success");
      }else{
         renderText("add student error");
      }
   }

   public void getAllStudent(){
      List<Student> list = Student.stu.find("select * from Student");
      System.out.println(list.size());
      renderJson(list);
   }

   public void deleteStudent(){
      System.out.println(getParaToInt("id").toString());
      boolean f = Student.stu.deleteById(getParaToInt("id"));
      System.out.println(f);
   }

   public void getoneStudent(){
      System.out.println(getParaToInt("sid").toString());
      Student student = Student.stu.findById(getParaToInt("sid").toString());
      System.out.println(student.get("sname"));
      this.setSessionAttr("stu",student);
      renderJson(student);
   }

   public void updateStudent(){
      Student student = getModel(Student.class,"student");
      System.out.println(student.get("sid"));
      boolean f = student.update();
      if(f){
         renderText("update success");
      }else{
         renderText("update error");
      }
   }


}
