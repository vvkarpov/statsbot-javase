package ru.vkarpov.bots.utils;

import ru.vkarpov.bots.model.Stats;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CreateBotAnswer {

    public static String botAnswer() throws IOException {
        Stats stats = ParserYandexAPIAnswer.createStatsObj();

        return URLEncoder.encode("Показы: " + stats.getImpressions() + "\n" +
                "Клики: " + stats.getClicks() + "\n" +
                "CTR, %: " + stats.getCtr() + "\n" +
                "Отказы,% : " + stats.getBounceRate() + "\n" +
                "Потрачено,руб : " + stats.getCost() + "\n" +
                "Ср.стоимость кликов, руб: " + stats.getAvgCPC(), StandardCharsets.UTF_8);
    }

}
