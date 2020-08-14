package com.zerostech.rpc;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created on 2019-12-13.
 *
 * @author 迹_Jason
 */
public interface RmiService extends Remote {

    String hello(String name) throws RemoteException;


}
