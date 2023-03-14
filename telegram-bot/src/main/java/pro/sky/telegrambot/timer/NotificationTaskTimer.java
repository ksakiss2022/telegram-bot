package pro.sky.telegrambot.timer;

import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pro.sky.telegrambot.model.TelegramBotClient;
import pro.sky.telegrambot.service.NotificationTaskService;

@Component
public class NotificationTaskTimer {

    private final NotificationTaskService notificationTaskService;
    private final TelegramBotClient telegramBotClient;
    //  private final TelegramBot telegramBot;

    public NotificationTaskTimer(NotificationTaskService notificationTaskService, TelegramBotClient telegramBotClient) {
        this.notificationTaskService = notificationTaskService;
        this.telegramBotClient = telegramBotClient;
    }

    @Scheduled(fixedDelay = 60 * 1_000)
    public void checkNotifications() {
        notificationTaskService.notificationsForSend().forEach(notificationTask -> {
            //     telegramBot.execute(
            telegramBotClient.execute(
                    new SendMessage(notificationTask.getUserId(),
                            "Вы просили напомнить об этом:" + notificationTask.getMassage())
            );
            notificationTaskService.deleteTask(notificationTask);
        });
    }
}
