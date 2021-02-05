package ru.vkarpov.bots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

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
