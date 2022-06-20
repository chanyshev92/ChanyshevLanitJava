package models;

import java.util.HashMap;

/** Словари */
public class Dictionaries {

    private static final HashMap<Integer, String> priorities = new HashMap<>();
    private static final HashMap<Integer, String> queues = new HashMap<>();
    private static final HashMap<Integer, String> statuses = new HashMap<>();

    static {
        priorities.put(1, "1. Critical");
        priorities.put(2, "2. High");
        priorities.put(3, "3. Normal");
        priorities.put(4, "4. Low");
        priorities.put(5, "5. Very Low");

        queues.put(1, "Django Helpdesk");
        queues.put(2, "Some Product");

        statuses.put(1, "Open");
        statuses.put(2, "Resolved");
        statuses.put(3, "Closed");
        statuses.put(4, "Duplicate");
    }

    public static String getPriority(int priority) {
        return priorities.get(priority);
    }

    public static String getQueue(int queue) {
        return queues.get(queue);
    }

    public static String getStatus(int status){ return statuses.get(status); }
}
