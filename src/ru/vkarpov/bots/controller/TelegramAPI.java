package ru.vkarpov.bots.controller;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ru.vkarpov.bots.service.Property;

public class TelegramAPI extends TelegramLongPollingBot {

    final static private String BOT_USER_NAME = Property.getProperties("BOT_USER_NAME");
    final static private String BOT_TOKEN = Property.getProperties("BOT_TOKEN");

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
            sendMessage.setText("Statistics for yesterday: 0 visitor's | 0 click's");
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
