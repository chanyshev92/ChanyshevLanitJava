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
    private WebElement dueDate = driver.findElement(By.xpath("//th[text()='Due Date']/following-sibling::td[1]"));

    private WebElement title=driver.findElement(By.xpath("//h3"));

    //@FindBy(xpath = "//th[contains(text(), 'Queue:')]")//h3/following-sibling::text()")
    private WebElement queue=driver.findElement(By.xpath("//th[contains(text(), 'Queue:')]"));

    private WebElement email = driver.findElement(By.xpath("//th[text()='Submitter E-Mail']/following-sibling::td[1]"));

    private WebElement priority = driver.findElement(By.xpath("//th[text()='Priority']/following-sibling::td[1]"));

    private WebElement description = driver.findElement(By.xpath("//*[@id='ticket-description']/p"));

    public TicketPage() {
        //PageFactory.initElements(driver,this);
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

    public void setDescription(WebElement description) {
        this.description = description;
    }

    @Step("Проверить значение полей на странице тикета")
    public void checkTicket(Ticket ticket) {
        Assert.assertTrue(getTitle().getText().contains(ticket.getTitle()), "Имя тикета не соответствует");
        Assert.assertTrue(getQueue().getText().contains(Dictionaries.getQueue(ticket.getQueue())), "Очередность не соответствует");
        Assert.assertTrue(getPriority().getText().contains(Dictionaries.getPriority(ticket.getPriority())), "Приоритет не соответствует");
        Assert.assertTrue(getEmail().getText().contains(ticket.getSubmitter_email()), "Email отправителя не соответствует");
        Assert.assertTrue(getDescription().getText().contains(ticket.getDescription()), "Описание не соответствует");
        Assert.assertTrue(getDueDate().getText().contains(ticket.getDue_date()),"Дата не соответствует");
    }
}
