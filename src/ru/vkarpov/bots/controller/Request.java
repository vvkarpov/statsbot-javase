package ru.vkarpov.bots.controller;

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

public class Request {

    final static private String JSON_URL = "https://api.direct.yandex.com/json/v5/reports";
    final static private String OAUTH_TOKEN = "";
    final static private String LOGIN = "";

    public static String getStats() throws IOException {

        final URL url = new URL(JSON_URL);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();

        //Header params
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Authorization", "Bearer " + OAUTH_TOKEN);
        con.setRequestProperty("Client-Login", LOGIN);
        con.setRequestProperty("Accept-Language", "en");
        con.setRequestProperty("returnMoneyInMicros", "false");
        con.setRequestProperty("skipReportHeader", "true");
        con.setRequestProperty("skipColumnHeader", "true");
        con.setRequestProperty("skipReportSummary", "true");
        con.setDoOutput(true);

        byte[] out = "{\"DateRangeType\":\"YESTERDAY\",\"ReportType\":\"ACCOUNT_PERFORMANCE_REPORT\"}".getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        con.setFixedLengthStreamingMode(length);
        con.connect();
        try (OutputStream os = con.getOutputStream()) {
            os.write(out);
        }

    }
// Do something with http.getInputStream()

}