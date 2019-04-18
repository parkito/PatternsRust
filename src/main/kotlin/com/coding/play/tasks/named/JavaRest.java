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

public class JavaRest {

    private static final String SITE_URL = "https://jsonmock.hackerrank.com/api/stocks";
    private static final String AND = "&";
    private static final String DAY_SEARCH_REGEXP = "/search?date=%s";
    private static final String PAGE_NUMBER_REGEXP = "page=$d";
    private static final String DEFAULT_PAGE_SIZE = "per_page=500";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MMMM-YYYY");

    public static void main(String[] args) {
        openAndClosePrices("1-January-2000", "22-February-2000", "Monday");
    }


    static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
        List<String> dayList = getDayList(firstDate, lastDate, weekDay);
        for (String day : dayList) {
            int pagesForDay = getPagesForDayAndPrintFirst(day);
//            if (pagesForDay > 1) {
//                for (int i = 2; i < pagesForDay; i++) {
//                    printDataForDay(day, i);
//                }
//            }
        }
    }

    private static List<String> getDayList(String firstDate, String lastDate, String weekDay) {
        List<String> result = new ArrayList<>();

        try {
            LocalDate startDate = LocalDate.from(DATE_FORMAT.parse(firstDate));
            LocalDate endDate = LocalDate.from(DATE_FORMAT.parse(lastDate));
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(weekDay);

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


    private static String buildHttpQuery(String firstDate, String lastDate) {
        return null;
    }


    private static int getPagesForDayAndPrintFirst(String day) {
        try {
            StringBuilder addressBuilder = new StringBuilder();
            String searchPart = String.format(DAY_SEARCH_REGEXP, day);
            addressBuilder.append(SITE_URL).append(searchPart).append(AND).append(DEFAULT_PAGE_SIZE);

            URL url = new URL(addressBuilder.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);


            // retrieve result
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            br.close();

            System.out.println(sb.toString());
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }

        return 0;

    }
}