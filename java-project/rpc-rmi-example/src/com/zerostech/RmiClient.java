package com.zerostech;

import java.rmi.Naming;

/**
 * Created on 2019-12-13.
 *
 * @author 迹_Jason
 */
public class RmiClient {
    public static void main(String[] args) {
        try {
            // 根据注册的服务地址来查找服务，然后就可以调用API对应的方法了
            RmiService service = (RmiService) Naming.lookup("rmi://localhost:9999/service1");
            System.out.println(service.hello("RMI"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
