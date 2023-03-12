package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
   private  final TelegramBot telegramBot;

    public TelegramBotUpdatesListener(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    private long lastProcessedMessageId = 0;

    @Override
    public int process(List<Update> updates) {
        for (Update update : updates) {
            if (update.message() != null && update.message().text() != null) {
                bot.execute(new SendMessage(update.message().chat().id(), "Вы отправили сообщение: " + update.message().text()));
                lastProcessedMessageId = update.message().messageId();
            }
        }
        //return (int) lastProcessedMessageId;
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private notificationTask pars(String s) {
        LocalDateTime dateTime = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        String massage = s.substring(s.lastIndexOf(":") + 3);
        notificationTask example = new notificationTask();
        example.setDateTime(dateTime);
        example.setMassage(massage);
        return example;
    }
}


