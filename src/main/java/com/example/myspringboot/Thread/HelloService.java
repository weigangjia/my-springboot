package com.example.myspringboot.Thread;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 类名称：HelloService<br>
 * 类描述：<br>
 * 创建时间：2018年11月14日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class HelloService {

    RateLimiter rateLimiter = RateLimiter.create(10);

    public void  doRequest(){

        if (rateLimiter.tryAcquire()){
            System.out.println("请求成功！");
        }else{
            System.out.println("请求过多，请稍后重试");
        }

    }
}
