package com.example.myspringboot.test;

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
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello,this is a springboot demo";
    }
}
