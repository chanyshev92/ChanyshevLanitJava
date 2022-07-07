package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Helpdesk")
public class HelpdeskPage extends WebPage {

    @Name("Summary of the problem")
    private SelenideElement shortDescriptionProblemField = $x("//*[@id='id_title']");

    @Name("Username")
    private SelenideElement userNameField = $x("//*[@id='username']");

    @Name("Password")
    private SelenideElement passwordField = $x("//*[@id='password']");

    @Name("Log In")
    private SelenideElement loginLink = $x("//*[@id='userDropdown']");

    @Name("Login")
    private SelenideElement loginButton = $x("//*[@value='Login']");

    @Name("TicketList")
    private SelenideElement ticketListTable = $x("//table[@id='ticketTable']");

    @Name("Submit Ticket")
    private SelenideElement createTicket = $x("//*[@class='btn btn-primary btn-lg btn-block']");

    @Name("New Ticket")
    private SelenideElement newTicketSidebar = $x("//a[@href='/tickets/submit/']");

    @Name("Queue")
    private SelenideElement queue = $x("//select[@name='queue']");

    @Name("Description of your issue")
    private SelenideElement description = $x("//textarea[@id='id_body']");

    @Name("Priority")
    private SelenideElement priority = $x("//*[@id='id_priority']");

    @Name("Due on")
    private SelenideElement due_date = $x("//*[@id='id_due_date']");

    @Name("Your E-Mail Address")
    private SelenideElement submitterEmail = $x("//*[@id='id_submitter_email']");

    @Name("Edit details")
    private SelenideElement editTicket = $x ("//*[@class='btn btn-sm btn-warning float-right']");

    @Name("Attach file(s)")
    private SelenideElement file= $x ("//*[@id='ShowFileUpload']");

    @Name("Update This Ticket")
    private SelenideElement sub= $x ("//button[text()='Update This Ticket']");

    @Name("Status Closed")
    private SelenideElement status= $x ("//*[@id='st_closed']");

    @Name("Search...")
    private SelenideElement searchField = $x ("//*[@id='search_query']");

    @Name("GO")
    private SelenideElement searchGoButton = $x ("//*[@class='input-group-append']/button");

    @Name("Save Query")
    private SelenideElement saveRequest = $x ("//*[@data-target='#collapseTwo']");

    @Name("Query Results")
    private SelenideElement ticketTitle = $x ("//div[@class='tickettitle']/a");

    @Name("Saved Queries")
    private SelenideElement savedRequests = $x("//*[@id='ticketsDropdown']");

    @Name("Query Name")
    private SelenideElement text = $x ("//*[@id='id_title']");

    @Name("Save Query Button")
    private SelenideElement buttonSearch = $x ("//*[@aria-controls='collapseTwo']");

}

