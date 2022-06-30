package pages;

import io.qameta.allure.Step;
import models.Dictionaries;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/** Страница отдельного тикета (авторизированный пользователь) */
public class TicketPage extends HelpdeskBasePage {

    /* Верстка страницы может измениться, поэтому для таблиц вместо индексов строк и столбцов лучше использовать
       более универсальные локаторы, например поиск по тексту + parent, following-sibling и другие.

       Текст тоже может измениться, но в этом случае элемент не будет найден и тест упадет,
       а ошибку можно будет легко локализовать и исправить.
       В случае изменений ячеек таблицы, локатор будет продолжать работать, но будет указывать на другой элемент,
       поведение теста при этом изменится непредсказуемым образом и ошибку будет сложно найти. */
    private final WebElement dueDate = driver.findElement(By.xpath("//th[text()='Due Date']/following-sibling::td[1]"));

    private final WebElement assigned_to =driver.findElement(By.xpath("//th[text()='Assigned To']/following-sibling::td[1]"));

    private final WebElement status = driver.findElement(By.xpath("//h3"));

    private final WebElement title=driver.findElement(By.xpath("//h3"));

    //@FindBy(xpath = "//th[contains(text(), 'Queue:')]")//h3/following-sibling::text()")
    private final WebElement queue=driver.findElement(By.xpath("//th[contains(text(), 'Queue:')]"));

    private final WebElement email = driver.findElement(By.xpath("//th[text()='Submitter E-Mail']/following-sibling::td[1]"));

    private final WebElement priority = driver.findElement(By.xpath("//th[text()='Priority']/following-sibling::td[1]"));

    private final WebElement description = driver.findElement(By.xpath("//*[@id='ticket-description']/p"));

    private final WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));

    //private final WebElement agreeDeleteButton = driver.findElement(By.xpath("//button[contains(text(), 'Yes I Understand - Delete It Anyway')]"));

    public TicketPage() {
        //PageFactory.initElements(driver,this);
    }

    public WebElement getAssigned_to() {
        return assigned_to;
    }

    public WebElement getStatus() {
        return status;
    }

    public WebElement getDueDate() {
        return dueDate;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getQueue() {
        return queue;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPriority() {
        return priority;
    }

    public WebElement getDescription() {
        return description;
    }

    @Step("Проверить значение полей на странице тикета")
    public void checkTicket(Ticket ticket) {
        Assert.assertTrue(getStatus().getText().contains(Dictionaries.getStatus(ticket.getStatus())),"Статус тикета не соответствует");
        Assert.assertTrue(getAssigned_to().getText().contains(ticket.getAssigned_to()),"Ассоциированность не соответствует");
        Assert.assertTrue(getTitle().getText().contains(ticket.getTitle()), "Имя тикета не соответствует");
        Assert.assertTrue(getQueue().getText().contains(Dictionaries.getQueue(ticket.getQueue())), "Очередность не соответствует");
        Assert.assertTrue(getPriority().getText().contains(Dictionaries.getPriority(ticket.getPriority())), "Приоритет не соответствует");
        Assert.assertTrue(getEmail().getText().contains(ticket.getSubmitter_email()), "Email отправителя не соответствует");
        Assert.assertTrue(getDescription().getText().contains(ticket.getDescription()), "Описание не соответствует");
        Assert.assertTrue(getDueDate().getText().contains(ticket.getDue_date()),"Дата не соответствует");
        saveScreenshot(driver);

    }
    @Step("Удалить созданный тикет")
    public TicketsPage deleteTicket(){
        deleteButton.click();
        driver.findElement(By.xpath("//button[contains(text(), 'Yes I Understand - Delete It Anyway')]")).click();
        saveScreenshot(driver);
        return new TicketsPage();
    }
}
