package com.coding.play.tasks.named;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JavaRest {

    private static final String SITE_URL = "https://jsonmock.hackerrank.com/api/stocks";
    private static final String AND = "&";
    private static final String DAY_SEARCH_REGEXP = "/search?date=%s";
    private static final String DEFAULT_PAGE_SIZE = "per_page=500";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d-MMMM-yyyy", Locale.US);
    private static final String GET_METHOD = "GET";
    private static final String DATE_JSON_PART = "date";
    private static final String SPACE = " ";
    private static final String OPEN_JSON_PART = "open";
    private static final String CLOSE_JSON_PART = "close";

    public static void main(String[] args) {
        openAndClosePrices("1-January-2000", "22-February-2000", "Monday");
    }

    static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
        List<String> dayList = getDayList(firstDate, lastDate, weekDay);
        for (String day : dayList) {
            printPageForDay(day);
        }
    }

    private static List<String> getDayList(String firstDate, String lastDate, String weekDay) {
        List<String> result = new ArrayList<>();

        try {
            LocalDate startDate = LocalDate.from(DATE_FORMAT.parse(firstDate));
            LocalDate endDate = LocalDate.from(DATE_FORMAT.parse(lastDate));
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(weekDay.toUpperCase());

            for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
                if (date.getDayOfWeek().equals(dayOfWeek)) {
                    result.add(DATE_FORMAT.format(date));
                }
            }
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
        return result;
    }

    private static void printPageForDay(String day) {
        try {
            StringBuilder addressBuilder = new StringBuilder();
            String searchPart = String.format(DAY_SEARCH_REGEXP, day);
            addressBuilder.append(SITE_URL).append(searchPart).append(AND).append(DEFAULT_PAGE_SIZE);

            URL url = new URL(addressBuilder.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(GET_METHOD);
            con.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            br.close();

            while (true) {
                int indexOfDate = sb.indexOf(DATE_JSON_PART);
                if (indexOfDate > -1) {
                    String dateSubstring = sb.substring(indexOfDate + 7, indexOfDate + 28);
                    String dateString = dateSubstring.substring(0, dateSubstring.indexOf("\""));
                    if (!dateString.equals(day)) {
                        break;
                    }
                    System.out.print(dateString + SPACE);
                    int indexOfOpen = sb.indexOf(OPEN_JSON_PART);
                    if (indexOfOpen > -1) {
                        String openSubstring = sb.substring(indexOfOpen + 6, indexOfOpen + 28);
                        String openString = openSubstring.substring(0, openSubstring.indexOf(","));
                        System.out.print(openString + SPACE);
                        int indexOfClose = sb.indexOf(CLOSE_JSON_PART);
                        if (indexOfClose > -1) {
                            String closeSubstring = sb.substring(indexOfClose + 7, indexOfClose + 15);
                            String closeString = closeSubstring.substring(0, closeSubstring.indexOf("}"));
                            System.out.println(closeString);
                        }
                    }
                }
                break;
            }

        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }
}