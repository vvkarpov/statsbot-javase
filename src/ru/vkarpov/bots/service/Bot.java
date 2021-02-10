package ru.vkarpov.bots.service;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Bot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegram = new TelegramBotsApi();

        Bot bot = new Bot();
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
        return "@AdvertStatsBot";
    }

    @Override
    public String getBotToken() {
        return "1683780434:AAFYqEOEZNZaze2HhiIboUV36ZOiqgPK5ok";
    }
}
