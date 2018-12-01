package com.rmitemperature.server;

import com.rmitemperature.api.Temperature;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Geordi
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String name = "Class temperature";
        Registry registry = LocateRegistry
                .createRegistry(1047);
        Temperature temp = new TempObj();
        Temperature stub = (Temperature) UnicastRemoteObject.exportObject(temp, 0);
        registry.rebind(name, stub);
        System.out.println(temp + "\n");

        System.out.println("Server is running");
    }
}
