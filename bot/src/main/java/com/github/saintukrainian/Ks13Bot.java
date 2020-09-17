package com.github.saintukrainian;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Ks13Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String inputString = update.getMessage().getText().toLowerCase();
            String outString;
            List<String> output = new ArrayList<>();

            System.out.println(inputString);
            List<String> array = List.of(inputString.split("\\s|\\,\\s"));
            System.out.println(array);
            if (array.contains("привет")) {
                output.add("Здарова");
            }
            if (array.contains("расписание")) {
                LocalDate date = LocalDate.now();

                if (date.getDayOfWeek().toString() == "WEDNESDAY") {
                    System.out.println("Сегодня завал");
                    output.add("Сегодня завал");
                } else {
                    output.add("Расписание на сегодня: 3 пары!(");
                }

            }

            outString = output.stream().reduce((cur, prev) -> cur + ", " + prev).get();

            long chatId = update.getMessage().getChatId();

            SendMessage message = new SendMessage().setChatId(chatId).setText(outString);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {

        return "Бот_КС13";
    }

    @Override
    public String getBotToken() {

        return "863121581:AAGAShkJKzIkS_v2D7NLuxWqJii0zY7QyDc";
    }

}
