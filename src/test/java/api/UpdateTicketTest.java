package api;

import model.AuthToken;
import model.Status;
import model.Ticket;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

/** Обновление тикета */
public class UpdateTicketTest extends BaseTest {

    @Test
    public void updateTicketTest(){

        Ticket ticket = createTicket(buildNewTicket(Status.CLOSED,1));
        updateTicketNegative(ticket);

    }

    private void updateTicketNegative(Ticket ticket) {
        AuthToken authToken = login();
        ticket.setStatus(Status.OPEN.getCode());
        given()
                .body(ticket)
                .header("Authorization", "token " + authToken.getToken())
                .when()
                .put("/api/tickets/"+ticket.getId())
                .then()
                .statusCode(200);
    }
}
