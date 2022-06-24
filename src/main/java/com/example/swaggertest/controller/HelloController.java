package com.example.swaggertest.controller;

import com.example.swaggertest.entity.UserDemo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Helloworld test")
@RestController
public class HelloController {

    @ApiOperation(value = "Just for say Hello")
    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }


    @PostMapping("/search")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name", value = "姓名", required = true,paramType = "query"),
            @ApiImplicitParam(name="age", value = "年龄", required = true, paramType = "query", dataType = "Integer")
    })
    @ApiOperation("ApiImplicitParams test")
    public String search(String name, Integer age){
        return "The name is: " + name +", The age is: " + age +".";
    }

    @PostMapping("/add")
    @ApiOperation("测试添加")
    public String add(UserDemo userDemo){
        return userDemo.getName() + "今年" + userDemo.getAge() + "岁了！";
    }

    @GetMapping("/user/{id}")
    @ApiOperation("测试查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", required = true, paramType = "path", dataType = "Integer")
    })
    @ApiResponses({
            @ApiResponse(code = 408, message = "指定业务的报错信息，返回客户端"),
            @ApiResponse(code=400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径不正确或页面跳转路径不对")
    })
    public UserDemo queryById(@PathVariable("id") Long id){
        return new UserDemo(id,"Shawn",20);
    }
}
