# Stugan
Boka en stuga i fjällen!
- Som en turist vill jag kunna boka en stuga via webben och få en bekräftelse på att stugan är bokad.
- Som en administratör vill jag kunna se alla bokningar av stugor.

# Backend
Mappen _Backend_ har undermappen _stugan_ som innehåller ett projekt i Spring Boot för backendet. Databas H2 in-memory. Projektet har byggts upp genom att använda IntelliJ 2024.1 (med pluginet _Lombok_) .

Eftersom databasen är in-memory så kommer alla lagda bokningar att försvinna vid omstart (eftersom bokningarna lagras i databasen).

API för backend är initialt inställt på kommunikation över port 8081.

### Lombok

Projekt Lombok har används för diverse förenklande annoteringar. För källkoden i IntelliJ har pluginet "Lombok" därför använts. Samt att inställningen _Enable annotation processing_ har aktiverats.

> [Setting up Lombok with Eclipse and Intellij - Baeldung](https://www.baeldung.com/lombok-ide) 

## Appstart 
Ändra om önskvärt inloggningsuppgifterna under `application.properties`.

Starta från kommandoprompten genom `./gradlew bootRun` (från backend-projektets root-mapp)
Alternativt genom IntelliJ´s "Run" 

# Frontend

Frontend består av en server i NodeJs (express) som servar statisk html+javascript. Anledningen till server är att få CORS och restanrop från webbläsaren att lira.

### Inloggning

Den admin-delen av frontend där alla bokningar visas kräver inloggning. Dessa uppgifter specificeras i *application.properties* och är default `admin/admin`.

## Appstart

Förutsättning för att köra är att NodeJs (inklusive NPM) är installerat på systemet.

Initiera frontend-appen genom `npm install` (från backend-projektets root-mapp)

Starta frontend genom `node app.js` 
(Starta helst backend före frontend)

Frontend återfinns på `http://localhost:3000`. Det är också härigenom som hela lösningen körs.

# Test

Kör enhetstester av Spring Boot genom `./gradlew clean test`. i rootmappen för backend-delen av projektet. En sammanställning görs till `build/reports/tests/test/index.html`.

## Scenarion

Förslag på testscenarion (i den ordning de står). Dessa får i dagsläget genomföras manuellt men skulle framgent kunna automatiseras via tex Selenium.

- Öppna Frontend och boka en stuga, verifiera att bokningen går igenom.
- Öppna Frontend och boka samma stuga, samma datum. Verifiera att bokningen ej gått igenom på grund av dubbelbokning.
- Öppna Frontend och boka samma stuga,  ett annat datum, verifiera att bokningen går igenom.
- Öppna Frontend och boka en annan stuga, verifiera att bokningen går igenom.
- Klicka fram admin-sidan och logga in med felaktiga inloggningsuppgifter. Verifiera att inloggningen ej går igenom och att admin-sidan inte är åtkomlig.
- Klicka fram admin-sidan och logga in med korrekta inloggningsuppgifter. Verifiera att inloggningen går igenom och att admin-sidan är åtkomlig.
- Klicka fram admin-sidan och verifiera att den lista som nu visas stämmer överens med de bokningar som lagts i tidigare steg.
