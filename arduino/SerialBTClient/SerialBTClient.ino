//This example code is in the Public Domain (or CC0 licensed, at your option.)
//By Evandro Copercini - 2018
//
//This example creates a bridge between Serial and Classical Bluetooth (SPP)
//and also demonstrate that SerialBT have the same functionalities of a normal Serial

#include "BluetoothSerial.h"

#if !defined(CONFIG_BT_ENABLED) || !defined(CONFIG_BLUEDROID_ENABLED)
#error Bluetooth is not enabled! Please run `make menuconfig` to and enable it
#endif

BluetoothSerial SerialBT;

void setup() {
  Serial.begin(115200);
  pinMode(15,OUTPUT);
  SerialBT.begin("ESPGuitar"); //Bluetooth device name
  Serial.println("The device started, now you can pair it with bluetooth!");
}

void sendsongs(){
  SerialBT.println("DEB_SONGS");
  SerialBT.flush();
    delay(50);

  for (int i=0;i<=10;i++){
    SerialBT.println(i+"_song.txt");
  SerialBT.flush();
  delay(50);
  }
  SerialBT.println("FIN_SONGS");
  SerialBT.flush();
  delay(50);

}
void loop() {
  if (Serial.available()) {
    SerialBT.write(Serial.read());
  }
  if (SerialBT.available()) {
    String msg = SerialBT.readString();
    Serial.print(msg);
    if (msg == "SYNC") {
      sendsongs();
    }
    if (msg=="PLAY"){
      digitalWrite(15,HIGH);
      delay(500);
      digitalWrite(15,LOW);
    }
    delay(5);
  }
}
