package com.example.myspringboot.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：HelloController<br>
 * 类描述：<br>
 * 创建时间：2018年09月12日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@Api(value="测试接口",description="写着玩玩")
@RestController
@RequestMapping("/")
public class HelloController {

    @ApiOperation(value = "访问并返回一条问候语句", notes = "可好玩了", httpMethod = "POST")
    @RequestMapping("/")
    public String hello(){
        return "hello,this is a springboot demo!";
    }
}
