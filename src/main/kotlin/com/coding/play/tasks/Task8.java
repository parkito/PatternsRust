package com.coding.play.tasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task8 {
    class LogEntry {
        Date created;
        String login;
        String url;

        public Date getCreated() {
            return created;
        }

        public String getLogin() {
            return login;
        }

        public String getUrl() {
            return url;
        }
    }

    public static void main(String[] args) {
        List<LogEntry> logs = new ArrayList<>();

        Map<String, Long> clickCount =
                logs.stream()
                        .collect(Collectors.groupingBy(LogEntry::getUrl, Collectors.counting()));
    }
}
