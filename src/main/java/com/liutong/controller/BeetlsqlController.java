package com.liutong.controller;

import com.liutong.entity.User;
import com.liutong.service.UserService;
import com.liutong.util.ExcelDownLoad;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
//Api注解，描述信息 可通过tag进行分类
@Api(value = "HelloBeetlsql", description = "HelloBeetlsql")
public class BeetlsqlController {
    Log log = LogFactory.getLog(this.getClass());
    @Autowired
    UserService userService;
    @Value("${beetlsql.excel.path}")
    String path;

    @PostMapping("/selectUserById")
    @ApiOperation(notes = "根据id查询用户", value = "selectUserById")
    public User selectUser(@ApiParam(name = "id", value = "序号") @RequestParam("id") Integer id) {
        return userService.selectUserById(id);
    }


    @PostMapping("/selectUserByNameAndAge")
    @ApiOperation(notes = "根据姓名和年龄查询用户", value = "selectUserByNameAndAge")
    public List<User> selectUserByNameAndAge(@ApiParam(name = "name", value = "姓名") @RequestParam("name") String name,
                                             @ApiParam(name = "age", value = "年龄") @RequestParam("age") Integer age) {
        return userService.selectUserByNameAndAge(name, age);
    }

    @PostMapping("/selectUserByAge")
    @ApiOperation(notes = "根据年龄查询用户", value = "selectUserByAge")
    public List<User> selectUserByAge(@ApiParam(name = "age", value = "年龄") @RequestParam("age") Integer age,
                                      @ApiParam(name = "num1", value = "分页开始序号") @RequestParam("num1") Integer num1,
                                      @ApiParam(name = "num2", value = "分页结束序号") @RequestParam("num2") Integer num2) throws IOException {
        List<User> list = userService.selectUserByAge(age, num1, num2);
        //导出excel
        String sheetName = "新增用户列表";
        String[] title = {"id","姓名","年龄"};
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFWorkbook wb =  ExcelDownLoad.getHSSFWorkbook(sheetName,title,list,new HSSFWorkbook());

        String xslName = path +File.separator + System.currentTimeMillis()+".xlsx";
        //创建xls文件，无内容 0字节
        FileOutputStream fOut = new FileOutputStream(xslName);
        //写内容，xls文件已经可以打开
        wb.write(fOut);
        //刷新缓冲区
        fOut.flush();
        //关闭
        fOut.close();
        return list;
    }

    @PostMapping("/insertUser")
    @ApiOperation(notes = "添加用户", value = "insertUser")
    public String insertUser(@ApiParam(name = "name", value = "姓名") @RequestParam("name") String name,
                             @ApiParam(name = "age", value = "年龄") @RequestParam("age") Integer age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setCreateDate(new Date());
        Integer num = userService.insertUser(user);
        String result = "";
        if(num == 1){
            log.info("添加成功");
            result = "添加成功";
        }else{
            log.error("添加失败");
            result = "添加失败";
        }
        return result;
    }

    @PostMapping("/deleteUserById")
    @ApiOperation(notes = "根据id删除用户", value = "deleteUserById")
    public String deleteUserById(@ApiParam(name = "id", value = "序号") @RequestParam("id") Integer id) {
        Integer num = userService.deleteUserById(id);
        String result = "";
        if(num == 1){
            result = "删除成功";
            log.info("删除成功");
        }else{
            result = "删除失败";
            log.error("删除失败");
        }
        return result;
    }
}
