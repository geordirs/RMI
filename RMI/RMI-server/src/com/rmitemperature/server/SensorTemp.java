package com.rmitemperature.server;

import org.iot.raspberry.grovepi.devices.GroveTemperatureAndHumiditySensor;
import java.io.IOException;
import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.pi4j.GrovePi4J;
/*
 Connect Temp & Humidity sensor to D4
 */
public class SensorTemp{
  public double run() throws Exception {
    GrovePi grovePi = new GrovePi4J();
    GroveTemperatureAndHumiditySensor dht = new GroveTemperatureAndHumiditySensor(grovePi, 0, GroveTemperatureAndHumiditySensor.Type.DHT11);
      try {
        double temperature = dht.get().getTemperature();
        System.out.println(temperature);        
        return temperature;        
      } catch (IOException ex) {
      }
    return 0;
  }
}
