package ru.vkarpov.bots.service;

import ru.vkarpov.bots.controller.YandexAPI;
import ru.vkarpov.bots.model.Stats;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserAPIAnswer {

    public static Stats createStatsObj() throws IOException {
        Stats stats = new Stats();
        String str = YandexAPI.getStats();

        String[] parseArray = str.split("\t");
        List<String> list = Arrays.stream(parseArray).map(String::trim)
                .collect(Collectors.toList());

        stats.setImpressions(list.get(0));
        stats.setClicks(list.get(1));
        stats.setCtr(list.get(2));
        stats.setBounceRate(list.get(3));
        stats.setCost(list.get(4));
        stats.setAvgCPC(list.get(5));

        return stats;
    }

}
