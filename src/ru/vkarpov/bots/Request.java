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

    private static final int CONNECTION_TIMEOUT = 100;

    public static String getStats() throws IOException {

        String link = "https://api.direct.yandex.com/json/v5/reports";
        final URL url = new URL(link);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(CONNECTION_TIMEOUT);
        con.setReadTimeout(CONNECTION_TIMEOUT);

        //GET request
        /*
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
         */

        final Map<String, String> parameters = new HashMap<>();
        parameters.put("title", "foo");
        parameters.put("body", "bar");
        parameters.put("userId", "1");

        con.setDoOutput(true);
        final DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(getParamsString(parameters));
        out.flush();
        out.close();
    }

    public static String getParamsString(final Map<String, String> params) {
        final StringBuilder result = new StringBuilder();

        params.forEach((name, value) -> {
            result.append(URLEncoder.encode(name, StandardCharsets.UTF_8));
            result.append('=');
            result.append(URLEncoder.encode(value, StandardCharsets.UTF_8));
            result.append('&');
        });

        final String resultString = result.toString();
        return !resultString.isEmpty()
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

}