package models;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ticket {

    /* Класс Ticket пакета models реализуем по аналогии c домашним заданием по тестированию API.
       Класс должен содержать набор полей, необходимый для заполнения формы создания тикета.
       Тип данных для каждого поля должен соответствовать документации swagger (см. раздел Models в документации). */

    private Integer id=0;
    private String title;
    private String due_date;
    private File file;

    private Integer queue;
    private Integer status;
    private Integer priority;
    private String description;
    private String submitter_email;
    private Integer kbitem;
    private String assigned_to;

    public Ticket() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmitter_email() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }

    public Integer getKbitem() {
        return kbitem;
    }

    public void setKbitem(Integer kbitem) {
        this.kbitem = kbitem;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDue_date() {
        return due_date;
    }

    // обычный сеттер
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    // перегруженный сеттер, который принимает дату и форматирует её в строку по шаблону
    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && Objects.equals(title, ticket.title) && Objects.equals(due_date, ticket.due_date) && Objects.equals(file, ticket.file) && Objects.equals(queue, ticket.queue) && Objects.equals(status, ticket.status) && Objects.equals(priority, ticket.priority) && Objects.equals(description, ticket.description) && Objects.equals(submitter_email, ticket.submitter_email) && Objects.equals(kbitem, ticket.kbitem) && Objects.equals(assigned_to, ticket.assigned_to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, due_date, file, queue, status, priority, description, submitter_email, kbitem, assigned_to);
    }
}
