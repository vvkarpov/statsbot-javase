package ru.vkarpov.bots.controller;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ru.vkarpov.bots.service.CreateBotAnswer;
import ru.vkarpov.bots.service.ParserAPIAnswer;
import ru.vkarpov.bots.service.Property;

import java.io.IOException;

public class TelegramAPI extends TelegramLongPollingBot {

    final private static String BOT_USER_NAME = Property.getProperties("BOT_USER_NAME");
    final private static String BOT_TOKEN = Property.getProperties("BOT_TOKEN");

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegram = new TelegramBotsApi();

        TelegramAPI bot = new TelegramAPI();
        try {
            telegram.registerBot(bot);
        }catch (TelegramApiRequestException exp){
            exp.getStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        if(update.getMessage().getText().equals("/stats")){
            try {
                sendMessage.setText(CreateBotAnswer.botAnswer());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException exp){
                exp.getStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
