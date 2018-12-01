package com.rmitemperature.cliente;

import com.rmitemperature.api.Temperature;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geordi
 */
public class Main {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Scanner sc = new Scanner(System.in);
        String host = "172.19.18.58";
        String name = "Class temperature";
        
        int tempB = 12, tempA = 21;

        Registry registry = LocateRegistry
                .getRegistry(host, 1047);

        Temperature temp = (Temperature) registry.lookup(name);

        temp.getTemperature(tempA, tempB);
        temp.RgbLcd(temp.getTemperature(tempA, tempB));
        
        System.out.println("Message: "+temp.getTemperature(tempA, tempB));

    }
}
