package com.example.myspringboot.Thread;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 类名称：Demo<br>
 * 类描述：<br>
 * 创建时间：2018年11月14日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException, IOException {
        HelloService helloService = new HelloService();
        CountDownLatch latch = new CountDownLatch(1);
        Random random = new Random(10);
        for (int i = 0;i<20;i++){
            Thread t = new Thread(()->{
                try {
                    latch.await();
                    Thread.sleep(random.nextInt(1000));
                    helloService.doRequest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        latch.countDown();
        System.in.read();
    }
}
