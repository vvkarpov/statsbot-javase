package ru.vkarpov.bots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/*
AdvertStatsBot
1683780434:AAFYqEOEZNZaze2HhiIboUV36ZOiqgPK5ok
 */

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

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
