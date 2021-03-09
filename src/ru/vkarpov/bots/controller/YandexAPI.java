package ru.vkarpov.bots.controller;

import ru.vkarpov.bots.utils.Property;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/*
Адрес для JSON-запросов
https://api.direct.yandex.com/json/v5/reports
по протоколу HTTPS методом POST
Кодировка UTF-8

HEADER
Authorization: Bearer OAuth-токен
Client-Login: Login
Accept-Language: en
Content-Type: application/json; charset=utf-8
returnMoneyInMicros: false
skipReportHeader: true
skipColumnHeader: true
skipReportSummary: true

Impressions - кол-во показов
Clicks - кол-во кликов
Ctr - цтр
BounceRate - отказы
Cost - стоимость кликов
AvgCpc - Средняя стоимость клика}
*/

public class YandexAPI {

    final private static String JSON_URL = "https://api.direct.yandex.com/json/v5/reports";
    final private static String USER_OAUTH_TOKEN = Property.getProperties("USER_OAUTH_TOKEN");
    final private static String USER_LOGIN = Property.getProperties("USER_LOGIN");

    public static String getStats() throws IOException {

        final URL url = new URL(JSON_URL);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();

        //Header params
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Authorization", "Bearer " + USER_OAUTH_TOKEN);
        con.setRequestProperty("Client-Login", USER_LOGIN);
        con.setRequestProperty("Accept-Language", "en");
        con.setRequestProperty("returnMoneyInMicros", "false");
        con.setRequestProperty("skipReportHeader", "true");
        con.setRequestProperty("skipColumnHeader", "true");
        con.setRequestProperty("skipReportSummary", "true");
        con.setDoOutput(true);

        //Body params
        byte[] out = ("{\n" +
                "    \"params\": {\n" +
                "        \"SelectionCriteria\": {},\n" +
                "        \"FieldNames\": [\n" +
                "            \"Impressions\",\n" +
                "            \"Clicks\",\n" +
                "            \"Ctr\",\n" +
                "            \"BounceRate\",\n" +
                "            \"Cost\",\n" +
                "            \"AvgCpc\"\n" +
                "        ],\n" +
                "        \"ReportName\": \"НАЗВАНИЕ_ОТЧЕТА\",\n" +
                "        \"ReportType\": \"ACCOUNT_PERFORMANCE_REPORT\",\n" +
                "        \"DateRangeType\": \"YESTERDAY\",\n" +
                "        \"Format\": \"TSV\",\n" +
                "        \"IncludeVAT\": \"NO\",\n" +
                "        \"IncludeDiscount\": \"NO\"\n" +
                "    }\n" +
                "}").getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        con.setFixedLengthStreamingMode(length);

        con.connect();
        try (OutputStream os = con.getOutputStream()) {
            os.write(out);
        }

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        //System.out.println("Post parameters: " + new String(out, StandardCharsets.UTF_8));
        System.out.println("Response Code: " + responseCode);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            //print result
            System.out.println(response.toString());
            return response.toString();
        }
    }

}