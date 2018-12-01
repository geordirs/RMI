package com.rmitemperature.server;

import com.rmitemperature.api.Temperature;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geordi
 */
public class TempObj implements Temperature {

    private final SensorTemp tem = new SensorTemp();
    private final SensorDisplay pres = new SensorDisplay();
    String mensaje;

    @Override
    public String getTemperature(int temA, int temB) throws RemoteException {

        int TemMax, TemMin;

        int[] temps = {12, 17, 21};
        try {

            for (int i = 0; i < temps.length; i++) {

                if (tem.run() > temps[3]) {
                    mensaje = "Temperatura alta, \n"
                            + "Encienda el ventilador \n"
                            + "o "
                            + "Aire Acondicionado ";
                    System.out.println("Temp: " + temps[3] + "°C");
                    System.out.println(mensaje);
                } else if (tem.run() < temps[1]) {
                    mensaje = "Temperatura baja \n"
                            + "Ecienda el Aire Acondicionado";
                    System.out.println("Temp: " + temps[1] + "°C");
                    System.out.println(mensaje);
                } else {
                    mensaje = "Temperatura Normal";
                    System.out.println(mensaje);
                    System.out.println("Temp: " + temps[2] + "°C");

                    try {
                        double cTemp = tem.run() * 0.0625;
                        System.out.println(cTemp + "°C");
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TempObj.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }

    @Override
    public void RgbLcd(String texto) throws RemoteException {
        try {
            pres.run(texto);
        } catch (Exception ex) {
            Logger.getLogger(TempObj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
