package com.zerostech.rpc;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created on 2019-12-13.
 *
 * @author 迹_Jason
 */
public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {

    public RmiServiceImpl() throws RemoteException {
    }

    @Override
    public String hello(String name) throws RemoteException {
        return "Hello " + name;
    }

    public static void main(String[] args) {
        try {
            RmiService service = new RmiServiceImpl();
            //在本地创建和暴露一个注册服务实例，端口为9999
            LocateRegistry.createRegistry(9999);
            //注册service服务到上面创建的注册实例上
            Naming.rebind("rmi://127.0.0.1:9999/service1",service);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("------------server start-----------------");
    }

}
