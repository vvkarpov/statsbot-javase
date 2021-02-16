package ru.vkarpov.bots.controller;

import ru.vkarpov.bots.service.Property;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

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

BODY
DateRangeType: YESTERDAY
ReportType: ACCOUNT_PERFORMANCE_REPORT
FieldNames: Impressions; Clicks; Ctr; BounceRate; Cost; AvgCpc

{Impressions - кол-во показов
Clicks - кол-во кликов
Ctr - цтр
BounceRate - отказы
Cost - стоимость кликов
AvgCpc - Средняя стоимость клика}

QUESTIONS:
1. КАК ЗАПРОСИТЬ БАЛАНС?
*/

public class YandexAPI {

    final static private String JSON_URL = "https://api.direct.yandex.com/json/v5/reports";
    final static private String USER_OAUTH_TOKEN = Property.getProperties("USER_OAUTH_TOKEN");
    final static private String USER_LOGIN = Property.getProperties("USER_LOGIN");

    public static String getStats() throws IOException {

        final URL url = new URL(JSON_URL);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        final String answer;

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
        byte[] out = ("{\"DateRangeType\":\"YESTERDAY\",\"ReportType\":\"ACCOUNT_PERFORMANCE_REPORT\"," +
                "\"FieldNames\":\"Impressions\"}").getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        con.setFixedLengthStreamingMode(length);

        con.connect();
        try (OutputStream os = con.getOutputStream()) {
            os.write(out);
        }

        try (InputStream in = con.getInputStream()){
            byte[] array = in.readAllBytes();
            answer = Arrays.toString(array);
        }
        System.out.println(answer);
        return answer;
    }

}