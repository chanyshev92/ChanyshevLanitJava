package models;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ticket implements Serializable {

    /* Класс Ticket пакета models реализуем по аналогии c домашним заданием по тестированию API.
       Класс должен содержать набор полей, необходимый для заполнения формы создания тикета.
       Тип данных для каждого поля должен соответствовать документации swagger (см. раздел Models в документации). */

    private Integer id;
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
    private String modified;
    private Boolean on_hold;
    private String resolution;
    private String last_escalation;
    private String secret_key;

    private final static long serialVersionUID = 2468277671475621618L;

    public Ticket() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Boolean getOn_hold() {
        return on_hold;
    }

    public void setOn_hold(Boolean on_hold) {
        this.on_hold = on_hold;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getLast_escalation() {
        return last_escalation;
    }

    public void setLast_escalation(String last_escalation) {
        this.last_escalation = last_escalation;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && Objects.equals(title, ticket.title) && Objects.equals(due_date, ticket.due_date) && Objects.equals(file, ticket.file) && Objects.equals(queue, ticket.queue) && Objects.equals(status, ticket.status) && Objects.equals(priority, ticket.priority) && Objects.equals(description, ticket.description) && Objects.equals(submitter_email, ticket.submitter_email) && Objects.equals(kbitem, ticket.kbitem) && Objects.equals(assigned_to, ticket.assigned_to) && Objects.equals(modified, ticket.modified) && Objects.equals(on_hold, ticket.on_hold) && Objects.equals(resolution, ticket.resolution) && Objects.equals(last_escalation, ticket.last_escalation) && Objects.equals(secret_key, ticket.secret_key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, due_date, file, queue, status, priority, description, submitter_email, kbitem, assigned_to, modified, on_hold, resolution, last_escalation, secret_key);
    }
}
