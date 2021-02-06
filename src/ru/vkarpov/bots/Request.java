package ru.vkarpov.bots;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

//Адрес для JSON-запросов
//https://api.direct.yandex.com/json/v5/reports
//по протоколу HTTPS методом POST
//Кодировка UTF-8

public class Request {

    public static String getStats() throws IOException {

        final URL url = new URL("https://api.direct.yandex.com/json/v5/reports");
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setDoOutput(true);

        byte[] out = "{\"username\":\"root\",\"password\":\"password\"}".getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        con.setFixedLengthStreamingMode(length);
        con.connect();
        try(OutputStream os = con.getOutputStream()) {
            os.write(out);
        }
// Do something with http.getInputStream()

}