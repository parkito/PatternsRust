package com.coding.play.tasks.named;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JavaRest {

    public static final String SITE_URL = "https://jsonmock.hackerrank.com/api/stocks";
    public static final String SEARCH_REGEXP = "https://jsonmock.hackerrank.com/api/stocks";

    static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
        String httpQuery = buildHttpQuery(firstDate, lastDate);
        int pageNumber = getTotalPageNumber(httpQuery);

        for (int i = 0; i < pageNumber; i++) {
            printPricePage(httpQuery);
        }
    }

    private static String buildHttpQuery(String firstDate, String lastDate) {
        return null;
    }


    private static String buildWebQuery(Map<String, String> parameters) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            String key = URLEncoder.encode(entry.getKey(), "UTF-8");
            String value = URLEncoder.encode(entry.getValue(), "UTF-8");
            sb.append(key).append("=").append(value).append("&");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    private static int getTotalPageNumber(String query) {


    }

    private static void printPricePage(String query) {
        String query = buildWebQuery(parameters);

        URL url = new URL(address);

        URLConnection urlc = url.openConnection();
        urlc.setDoOutput(true);
        urlc.setAllowUserInteraction(false);

        // send query
        PrintStream ps = new PrintStream(urlc.getOutputStream());
        ps.print(query);
        ps.close();

        // retrieve result
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        br.close();
        return sb.toString();
    }