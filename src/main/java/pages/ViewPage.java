package pages;

import io.qameta.allure.Step;
import models.Dictionaries;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/** Страница просмотра карточки тикета (неавторизированный пользователь) */
public class ViewPage extends HelpdeskBasePage {

    // Способ объявления и инициализации элементов страницы через driver.findElement(locator)

    /* Инициализация сразу при объявлении элемента.
       Элемент должен присутствовать на странице браузера в момент создания объекта страницы new ViewPage() */
    private final WebElement queue = driver.findElement(By.xpath("//th[contains(text(), 'Queue:')]"));
    private final WebElement email = driver.findElement(By.xpath("//th[text()='Submitter E-Mail']/following-sibling::td[1]"));
    private final WebElement priority = driver.findElement(By.xpath("//th[text()='Priority']/following-sibling::td[1]"));

    // Пример поиска description, используя промежуточный элемент descriptionLabel
    private final WebElement descriptionLabel = driver.findElement(By.xpath("//th[text()='Description']"));
    // Поиск элемента можно выполнять не только относительно driver, но и относительно другого элемента
    private final WebElement description = descriptionLabel.findElement(By.xpath("./parent::*/following-sibling::tr[1]"));

    /* Поиск элемента по локатору.
       Используется для элементов, которых нет на странице браузера в момент создания объекта страницы,
       так как локатор может быть объявлен и проинициализирован до появления элемнета на странице. */
    private final By captionLocator = By.xpath("//table/caption");
    private final WebElement caption;


    public ViewPage() {
        // В данном случае инициализация через PageFactory не нужна,
        // но можем проинициализировать элементы по локаторам (если элементы отображаются)
        caption = driver.findElement(captionLocator);
    }

    @Step("Проверить значение полей на карточке тикета")
    public ViewPage checkTicket(Ticket ticket) {
        Assert.assertTrue(getTicketTitle().contains(ticket.getTitle()), "Имя тикета не соответствует");
        Assert.assertTrue(getQueueTitle().contains(Dictionaries.getQueue(ticket.getQueue())), "Очередность не соответствует");
        Assert.assertTrue(getPriorityTitle().contains(Dictionaries.getPriority(ticket.getPriority())), "Приоритет не соответствует");
        Assert.assertTrue(getEmailTitle().contains(ticket.getSubmitter_email()), "Email отправителя не соответствует");
        Assert.assertTrue(getDescriptionTitle().contains(ticket.getDescription()), "Описание не соответствует");
        saveScreenshot(driver);
        return this;
    }
    @Step("Получить очередность тикета")
    public String getQueueTitle() {
        saveScreenshot(driver);
        return queue.getText();
    }
    @Step("Получить email отправителя тикета")
    public String getEmailTitle() {
        saveScreenshot(driver);
        return email.getText();
    }
    @Step("Получить приоритет тикета")
    public String getPriorityTitle() {

        saveScreenshot(driver);
        return priority.getText();
    }

    @Step("Получить описание тикета")
    public String getDescriptionTitle() {

        saveScreenshot(driver);
        return description.getText();
    }

    @Step("Получить заголовок тикета")
    public String getTicketTitle() {
        // Если элемент появляется не сразу, можно выполнить ожидание по условию

        // условие видимости при поиске по локатору
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(captionLocator);

        // поиск с ожиданием по условию
        WebElement ticketTitle = new WebDriverWait(driver, 5).until(condition);
        saveScreenshot(driver);
        return ticketTitle.getText();
    }

    @Step("Сохранить id тикета в объект")
    public void saveId(Ticket ticket) {
        String captionText = caption.getText();
        String id = captionText.substring(captionText.indexOf("-") + 1, captionText.indexOf("]"));
        ticket.setId(Integer.parseInt(id));
        saveScreenshot(driver);
    }

    @Step("Сохранить status тикета в объект")
    public void saveStatus(Ticket ticket){
        ticket.setStatus(1);
        saveScreenshot(driver);
    }

    @Step("Сохранить assigned_to тикета в объект")
    public void saveAssignedTo(Ticket ticket){
        ticket.setAssigned_to("Unassigned");
        saveScreenshot(driver);
    }
}