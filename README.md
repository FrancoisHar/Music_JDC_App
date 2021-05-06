# GuitarApp

A simple Android bluetooth  app ton remote control the Guitar PLayer.

Thos code is supposed to work with a dedicated Arduino Firmare (in Arduino folder)

## Introduction

First step to manage a communication between ESP32/Arduino & the Phone (as a remote controler)

## Required Tools

1. [Android Studio IDE and SDK](http://developer.android.com/sdk/index.html)
2. ESP32 


## Setup

1. Clone this repo and open it inside of Android Studio. Note, a later SDK will work just fine (SDK 23+)
2. Build the app
3. Install the app to your connected Android phone. You will need to install special drivers and enable USB debugging on your phone for this to work. There are plenty of tutorials on the web for this.
4. Flash the ESP32 with the dedicated code.
5. Run the application on your phone after it installs. 

## TODO

1. PB with the bluetooth strings send from Arduino to Android : encoding to change
2. Play message to manage in App & Arduino.
3. Merge the Sacha's Arduino Code with this one.
4. Update GUI (sh***y style)



