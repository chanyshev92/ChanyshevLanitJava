package pages;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/** Страница создания тикета */
public class CreateTicketPage extends HelpdeskBasePage {

    @FindBy(xpath = "//select[@name='queue']")
    private WebElement selectQueue;

    @FindBy(xpath = "//*[@name='title']")
    private WebElement inputProblem;

    @FindBy(xpath = "//*[@id='id_body']")
    private WebElement description;

    @FindBy(xpath = "//*[@id='id_priority']")
    private WebElement priority;

    @FindBy(xpath = "//*[@id='id_due_date']")
    private WebElement due_date;

    @FindBy(xpath = "//*[@id='id_attachment']")
    private WebElement attachmentFile;

    @FindBy(xpath = "//*[@id='id_submitter_email']")
    private WebElement submitterEmail;

    @FindBy(xpath = "//*[@id='id_assigned_to']")
    private WebElement assigned_to;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitTicketButton;

    public CreateTicketPage() {
        PageFactory.initElements(driver,this);
    }

    @Step("Создать тикет")
    public CreateTicketPage createTicket(Ticket ticket) {
        setQueueProblem(ticket.getQueue());
        setInputProblem(ticket.getTitle());
        setDescriptionProblem(ticket.getDescription());
        setPriorityProblem(ticket.getPriority());
        setDueOnProblem(ticket.getDue_date());
        setSubmitterEmail(ticket.getSubmitter_email());
        clickOnSubmitButton();
        return this;
    }
    @Step("Ввести очередь проблемы: {queue}")
    private void setQueueProblem(Integer queue) {
        Select select =new Select(selectQueue);
        select.selectByValue(String.valueOf(queue));
    }
    @Step("Ввести приоритет проблемы: {description}")
    private void setDescriptionProblem(String description) {

        this.description.sendKeys(description);
    }
    @Step("Ввести приоритет проблемы: {priority}")
    private void setPriorityProblem(Integer priority) {
        Select select = new Select(this.priority);
        select.selectByValue(String.valueOf(priority));
    }

    @Step("Ввести дату решения проблемы: {due_date}")
    private void setDueOnProblem(String due_date) {

        this.due_date.click();
        String[] strings =due_date.split("-");
        List<WebElement> dateList =
                driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a"));


        dateList.stream().filter(a -> a.getText().equals(due_date)).findFirst().get().click();

    }

    @Step("Ввести email отославшего человека: {submitter_email}")
    private void setSubmitterEmail(String submitter_email) {
        submitterEmail.sendKeys(submitter_email);
    }

    @Step("Ввести имя проблемы: {text}")
    public void setInputProblem(String text) {
        inputProblem.sendKeys(text);
    }

    @Step("Нажать на кнопку создания тикета")
    public void clickOnSubmitButton() {
        submitTicketButton.click();
    }
}
