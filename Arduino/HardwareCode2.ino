#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>

#include <LiquidCrystal_I2C.h>
#include <SPI.h>

#include <MFRC522.h>

// set the LCD number of columns and rows
int lcdColumns = 16;
int lcdRows = 2;

// set LCD address, number of columns and rows
// if you don't know your display address, run an I2C scanner sketch
LiquidCrystal_I2C lcd(0x27, lcdColumns, lcdRows);

//Rfid 
#define RST_PIN D3
#define SS_PIN D4

byte readCard[4];
String tagID = "";
MFRC522 mfrc522(SS_PIN, RST_PIN);

//Wifi
String serverName= "http://192.168.131.205:8080/store/cardScan?userid=";
const char* ssid = "Redmi Note 9 Pro";
const char* password = "teerna2000";
String response="";

//buzzer
//#define BUZZER D8 //buzzer pin


boolean getID(); 

void setup() {
pinMode(D8, OUTPUT);  
 //Rfid card
  SPI.begin();
  mfrc522.PCD_Init();
  // initialize LCD
  lcd.init();
  // turn on LCD backlight
  lcd.backlight();
  // print message
  lcd.setCursor(2, 0);
  lcd.print("Welcome to");
  lcd.setCursor(5, 1);
  lcd.print("Store");
  Serial.print("Welcome to Store");
  delay(3000);
  lcd.clear();
  Serial.begin(9600);
  lcd.clear();
  //initialize wifi
  WiFi.begin(ssid, password);
  Serial.println("Connecting");
  while(WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());
}

void loop() {
if(WiFi.status()== WL_CONNECTED){
      lcd.setCursor(1, 0);
      lcd.print("Place Your Card");  
      if (getID()){
          lcd.clear();
          
          if(response=="Welcome to Store"){
            WiFiClient client;
            HTTPClient http;
            http.begin(client, ("http://192.168.131.205:8080/user/get/name?RFID="+tagID).c_str());
            int httpResponseCode = http.POST("");
            if (httpResponseCode>0) {
              Serial.print("HTTP Response code: ");
              Serial.println(httpResponseCode);
              String name = http.getString();
              Serial.println(name);
                lcd.setCursor(5, 0);
                lcd.print("Welcome");
                lcd.setCursor(1, 1);
                lcd.print(name);
              }
         else {
              Serial.print("Error code: ");
              Serial.println(httpResponseCode);
              }
      
            http.end();
          }
          

          if(response=="Bill Due"){
            digitalWrite(D8, HIGH);
            delay(100);
            WiFiClient client;
            HTTPClient http;
            http.begin(client, ("http://192.168.131.205:8080/cart/getTotalString?userid="+tagID).c_str());
            int httpResponseCode = http.POST("");
            if (httpResponseCode>0) {
              Serial.print("HTTP Response code: ");
              Serial.println(httpResponseCode);
              String total = http.getString();
              Serial.println(total);
                lcd.setCursor(2, 0);
                lcd.print("Bill Due");
                lcd.setCursor(2, 1);
                lcd.print("Rs "+total);
              }
         else {
              Serial.print("Error code: ");
              Serial.println(httpResponseCode);
              }
      
            http.end();
          }

            if(response=="Card not registered"){
            digitalWrite(D8, HIGH);
            delay(100);
                lcd.setCursor(0, 0);
                lcd.print("Card Not");
                lcd.setCursor(0, 1);
                lcd.print("Registered");
          }
          

          if(response=="Visit Again"){
            WiFiClient client;
            HTTPClient http;
            http.begin(client, ("http://192.168.131.205:8080/user/get/name?RFID="+tagID).c_str());
            int httpResponseCode = http.POST("");
            if (httpResponseCode>0) {
              Serial.print("HTTP Response code: ");
              Serial.println(httpResponseCode);
              String name = http.getString();
              Serial.println(name);
                lcd.setCursor(3, 0);
                lcd.print("Visit Again");
                lcd.setCursor(1, 1);
                lcd.print(name);
              }
         else {
              Serial.print("Error code: ");
              Serial.println(httpResponseCode);
              }
      
            http.end();
          }
          

          
          delay(2000);
          lcd.clear();
          digitalWrite(D8, LOW);
          serverName= "http://192.168.131.205:8080/store/cardScan?userid=";
        }
    }else {
      Serial.println("WiFi Disconnected");
  }
}

boolean getID(){
    //Getting ready for Reading PICCs
  if(!mfrc522.PICC_IsNewCardPresent()){ //If new PICC placed to RFID reader continue
    return false;
    }

  if(!mfrc522.PICC_ReadCardSerial()){ //Since a PICC placed get serial and continue
    return false;
    }
    tagID = "";
    for (uint8_t i = 0; i < 4; i++){
      tagID.concat(String(mfrc522.uid.uidByte[i], HEX));
      }
      tagID.toUpperCase();
      mfrc522.PICC_HaltA();
      WiFiClient client;
      HTTPClient http;
      serverName=serverName+""+tagID;
      Serial.println("servername: "+serverName);
      response="";
      http.begin(client, serverName.c_str());
      int httpResponseCode = http.POST("");
      if (httpResponseCode>0) {
        Serial.print("HTTP Response code: ");
        Serial.println(httpResponseCode);
        response = http.getString();
        Serial.println(response);
      }
      else {
        Serial.print("Error code: ");
        Serial.println(httpResponseCode);
      }
      // Free resources
      http.end();
      return true;
  }

  
