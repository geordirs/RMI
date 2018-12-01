
package com.rmitemperature.api;
import java.rmi.Remote;
import java.rmi.RemoteException;
import org.iot.raspberry.grovepi.GrovePi;


public interface Temperature extends Remote{
    public String getTemperature(int temA, int temB) throws RemoteException;  
    public void RgbLcd(String texto) throws RemoteException;       
}
