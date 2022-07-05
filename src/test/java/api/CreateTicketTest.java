package api;

import model.AuthToken;
import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/** Создание и проверка тикета */
public class CreateTicketTest extends BaseTest {

    @Test
    public void createTicketTest() {
        Ticket ticket = createTicket(buildNewTicket(Status.OPEN,1));

        Assert.assertEquals(getTicket(ticket.getId()).getId(),ticket.getId(), "tickets are not equal");
    }

    protected Ticket getTicket(int id) {
        AuthToken authToken = login();

        return given().
                when()
                .header("Authorization", "token " + authToken.getToken())
                .get("/api/tickets/"+id)
                .then()
                //.log().all()
                .statusCode(200)
                .extract()
                .body().as(Ticket.class);
    }
}
