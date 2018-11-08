package com.example.myspringboot.zk;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 类名称：Consumer<br>
 * 类描述：<br>
 * 创建时间：2018年11月08日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class Consumer {

    private List<String > serverList = new ArrayList<>();

    private String serviceName = "serviceA";

    public void init() throws Exception {
        //服务地址,产生连接
        String zkServer = "192.168.244.4:2181";
        ZkClient zkClient = new ZkClient(zkServer);

        String serverPath = "/configcentent/" + serviceName;
        boolean isExists = zkClient.exists(serverPath);

        //判断这个节点存不存在
        if (isExists){
            //存在，则获取该节点下的所有节点
            serverList = zkClient.getChildren(serverPath);
        }else{
            throw new Exception("error");
        }

        zkClient.subscribeChildChanges(serverPath, new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println("服务节点发生变化，节点的信息：" + list);
                serverList = list;
            }
        });
    }

    public void consume(){
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        System.out.println(i);
        System.out.println("调用：" + serverList.get(i) + "提供的服务");
    }

    public static void main(String[] args) throws Exception {
        Consumer c = new Consumer();
        c.init();
        for (int i = 0; i < 10; i++){
            c.consume();
            Thread.sleep(5000);
        }
        c.consume();
        System.in.read();
    }
}
