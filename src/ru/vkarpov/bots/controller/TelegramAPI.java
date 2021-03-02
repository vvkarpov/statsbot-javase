package ru.vkarpov.bots.controller;

import ru.vkarpov.bots.utils.CreateBotAnswer;
import ru.vkarpov.bots.utils.Property;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TelegramAPI {

    final private static String BOT_TOKEN = Property.getProperties("BOT_TOKEN");
    final private static String CHAT_ID = Property.getProperties("CHAT_ID");
    final private static String URL_REQUEST = "https://api.telegram.org/";

    public static void main(String[] args) throws IOException {

        String urlParams = "bot" +
                BOT_TOKEN +
                "/sendMessage?chat_id=" +
                CHAT_ID +
                "&text=" +
                CreateBotAnswer.botAnswer();

        URL obj = new URL(URL_REQUEST + urlParams);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
    }

}
