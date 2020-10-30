#include <SPI.h>
#include <Console.h>
#include <Bridge.h>
#include <BridgeServer.h>
#include <BridgeClient.h>

int valSensorP;
int valorSensorC;
int input;
float valorP;
float valorC ;
int c;


BridgeServer server(8080);
BridgeClient client;


float getPH() {
  // get the reading from the ph sensor
  valSensorP = analogRead(A0);
  valorP = valSensorP/36;
  Console.println(valorP);

  return valorP;
}

float getC() {
  // get the reading from the cond sensor
  //valorSensorC = analogRead(A1);
 // valorC = valorSensorC*0.008;
  valorC = random(0,50); // Demo
  return valorC;
}


void setup() {
  pinMode(13,OUTPUT);
  Bridge.begin();
  server.begin();
  Serial.begin(9600);
}

void loop() {
  client = server.accept();
  if (client) {
    c = client.read();
    Console.println(c);
    input = (c*1000);
    delay(3000);
    c = client.read();
    Console.println(c);
  }
  if(c == 1){ //When Arduino receives '1' go to connection()
      connection();
      }
 }

void connection(){ //Connect with Java to send the data
      getPH();
      client.write(valorP);
      client.flush();
      Console.println("PH data sent");
      getC();
      client.write(valorC);
      client.flush();
      Console.println("Conductivity data sent");
      delay(input); //Wait the time you want to get another sample
}