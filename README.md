# Stugan
Boka en stuga i fjällen!
- Som en turist vill jag kunna boka en stuga via webben och få en bekräftelse på att stugan är bokad.
- Som en administratör vill jag kunna se alla bokningar av stugor.

# Backend
Mappen _Backend_ har undermappen _stugan_ som innehåller ett projekt i Spring Boot för backendet. Databas H2 in-memory. Projektet har byggts upp genom att använda IntelliJ 2024.1 (med pluginet _Lombok_) .

Eftersom databasen är in-memory så kommer alla lagda bokningar att försvinna vid omstart (eftersom bokningarna lagras i databasen).

## Appstart 
Ändra om önskvärt inloggningsuppgifterna under `application.properties`.

Starta från kommandoprompten genom `./gradlew bootRun` (från backend-projektets root-mapp)
Alternativt genom IntelliJ´s "Run" 

# Frontend

Frontend består av en server i NodeJs (express) som servar statisk html+javascript. Anledningen till server är att få CORS och restanrop från webbläsaren att lira.

## Appstart

Förutsättning för att köra är att NodeJs (inklusive NPM) är installerat på systemet.

Initiera frontend-appen genom `npm init` (från backend-projektets root-mapp)

Starta frontend genom `node app.js` 