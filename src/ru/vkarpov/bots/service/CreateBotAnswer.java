package ru.vkarpov.bots.service;

import ru.vkarpov.bots.model.Stats;

import java.io.IOException;

public class CreateBotAnswer {

    public static String botAnswer() throws IOException {
        Stats stats = ParserAPIAnswer.createStatsObj();

        return "Показы: " + stats.getImpressions() + "\n" +
                "Клики: " + stats.getClicks() + "\n" +
                "CTR, %: " + stats.getCtr() + "\n" +
                "Отказы, %: " + stats.getBounceRate() + "\n" +
                "Потрачено, руб: " + stats.getCost() + "\n" +
                "Ср.стоимость кликов, руб: " + stats.getAvgCPC();
    }

}
