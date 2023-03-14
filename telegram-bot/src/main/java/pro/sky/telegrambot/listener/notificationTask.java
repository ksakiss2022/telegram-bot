
package pro.sky.telegrambot.listener;

import java.time.LocalDateTime;

public class notificationTask {
    private LocalDateTime dateTime;
    private String massage;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
