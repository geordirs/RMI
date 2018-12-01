package com.rmitemperature.server;

import java.io.IOException;
import java.util.Random;
import org.iot.raspberry.grovepi.GrovePi;
import org.iot.raspberry.grovepi.devices.GroveRgbLcd;
import org.iot.raspberry.grovepi.pi4j.GrovePi4J;

public class SensorDisplay{
  
  public void run(String texto) throws Exception {
    GrovePi grovePi = new GrovePi4J();
    GroveRgbLcd lcd = grovePi.getLCD();

    String phrases = texto;
    
      try {
        String text = phrases;
        lcd.setText(text);
        Thread.sleep(2000);
      } catch (IOException io) {
      }
    
  }

}
