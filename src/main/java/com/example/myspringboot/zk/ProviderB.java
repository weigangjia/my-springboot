package com.example.myspringboot.zk;

import org.I0Itec.zkclient.ZkClient;

import java.io.IOException;

/**
 * 类名称：ProviderA<br>
 * 类描述：<br>
 * 创建时间：2018年11月08日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class ProviderB {

    private String serviceName = "serviceA";

    //根节点
    private final String ROOT = "/configcentent";

    public void init(){
        //服务地址,产生连接
        String zkServer = "192.168.244.4:2181";
        ZkClient zkClient = new ZkClient(zkServer);
        //判断根节点是否存在，不存在则创建
        if (!zkClient.exists(ROOT)){
            zkClient.createPersistent(ROOT);
        }

        if (!zkClient.exists(ROOT + "/" + serviceName)){
            zkClient.createPersistent(ROOT + "/" + serviceName);
        }

        String ip = "192.168.244.131:8080";
        zkClient.createEphemeral(ROOT + "/" + serviceName + "/" + ip);
        System.out.println("providerB服务启动成功");
    }

    public static void main(String[] args) throws IOException {
        ProviderB providerA = new ProviderB();
        providerA.init();
        System.in.read();
    }
}
