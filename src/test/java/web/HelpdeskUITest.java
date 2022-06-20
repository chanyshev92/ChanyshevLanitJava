package web;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;
    private Ticket ticket;

    @BeforeClass
    public void setup() throws IOException {
        loadProperties();
        setupDriver();
    }

    @Step("Загрузить конфигурацилнные файлы")
    private void loadProperties() throws IOException {
        // Читаем конфигурационные файлы в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
    }

    @Step("Создать экземпляр драйвера")
    private void setupDriver() {
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() {

        MainPage mainPage = new MainPage();
        driver.get("https://at-sandbox.workbench.lanit.ru/");
        mainPage.mainMenu().clickOnNewTicketButton();
        // ...
        ticket = buildNewTicket();
        // ...
        CreateTicketPage createTicketPage=new CreateTicketPage();
        createTicketPage.createTicket(ticket);

        ViewPage viewTicketWithoutLogInPage = new ViewPage();
        viewTicketWithoutLogInPage.saveId(ticket);
        viewTicketWithoutLogInPage = viewTicketWithoutLogInPage.checkTicket(ticket);

        mainPage.mainMenu().clickOnLogInButton();

        LoginPage loginPage = new LoginPage();
        loginPage.login(System.getProperty("user"),System.getProperty("password"));

        mainPage.mainMenu().searchTicket(this.ticket);
        TicketsPage ticketListPage = new TicketsPage();
        ticketListPage.openTicket(this.ticket);
        TicketPage viewTicketWithLogInPage = new TicketPage();
        viewTicketWithLogInPage=viewTicketWithLogInPage.checkTicket(ticket);

    }

    private Ticket buildNewTicket() {
        Ticket ticket = new Ticket();
        ticket.setTitle("No DATA");
        ticket.setDescription("No data about my Lanit interview))");
        ticket.setDue_date("25");
        ticket.setPriority(2);
        ticket.setQueue(1);
        ticket.setSubmitter_email("chanyshev92@yandex.ru");
        ticket.setId(0);
        ticket.setStatus(1);
        ticket.setAssigned_to("Unassigned");
        return ticket;
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            // Закрываем одно текущее окно браузера
            driver.close();
            // Закрываем все открытые окна браузера, завершаем работу браузера, освобождаем ресурсы
            driver.quit();
        }
    }
}
