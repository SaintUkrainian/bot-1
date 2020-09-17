package com.github.saintukrainian;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Bot {
    public static void main(String[] args) {
        // init api
        ApiContextInitializer.init();

        // init bot
        TelegramBotsApi botsApi = new TelegramBotsApi();

    
        // register bot
        try {
            botsApi.registerBot(new Ks13Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }
}
