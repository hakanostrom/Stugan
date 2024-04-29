package se.hakanostrom.stugan.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

// Samla felmeddelanden till en fil för att lättare ändra eventuell feltext, felkod eller liknande
public class StuganResponseException extends ResponseStatusException {

    public StuganResponseException(HttpStatusCode status, String reason) {
        super(status, reason);
    }

    public static StuganResponseException dubbelbokat() {
        return new StuganResponseException(HttpStatus.CONFLICT, "Dubbelbokat! Det finns redan en bokning på denna stuga denna dag");
    }

    public static StuganResponseException ogiltigNyckel() {
        return new StuganResponseException(HttpStatus.UNAUTHORIZED, "Ogiltig eller ingen api-nyckel");
    }

    public static StuganResponseException ogiltigLogin() {
        return new StuganResponseException(HttpStatus.UNAUTHORIZED, "Ogiltigt användarnamn och lösenod");
    }
}
