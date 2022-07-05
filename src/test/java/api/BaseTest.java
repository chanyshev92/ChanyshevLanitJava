package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import model.AuthToken;
import model.Status;
import model.Ticket;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static io.restassured.RestAssured.given;

/** Абстрактный класс, содержащий общие для всех тестов методы */
public abstract class BaseTest {
    @BeforeClass
    public void prepare() throws IOException {

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));

        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"base.uri\"");
        }

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();


    }

    protected AuthToken login() {

        AuthToken authToken=new AuthToken();

        String username = System.getProperty("username");
        String password = System.getProperty("password");

        authToken.setUsername(username);
        authToken.setPassword(password);

        return given()
                .body(authToken)
                .when().post("/api/login")
                .then().statusCode(200)
                .extract().body().as(AuthToken.class);
    }

    protected Ticket buildNewTicket(Status status, int priority) {

        Ticket ticket =new Ticket();

        ticket.setTitle("title");
        ticket.setStatus(status.getCode());
        ticket.setQueue(1);
        ticket.setPriority(priority);

        return ticket;
    }

    protected Ticket createTicket(Ticket ticket) {
        return
                given()
                .body(ticket)
                .when().post("/api/tickets")
                .then()
                .statusCode(201)
                .extract()
                        .as(Ticket.class);
    }
}
