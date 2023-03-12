package pro.sky.telegrambot.model;

import com.pengrad.telegrambot.model.*;

import java.io.Serializable;
import java.util.Objects;

public class TelegramBot implements Serializable {
    private final static long serialVersionUID = 0L;
    //   TelegramBot bot = new TelegramBot("BOT_TOKEN");
    private Integer update_id;
    private Message message;
    private Message edited_message;
    private Message channel_post;
    private Message edited_channel_post;
    private InlineQuery inline_query;
    private ChosenInlineResult chosen_inline_result;
    private CallbackQuery callback_query;
    private ShippingQuery shipping_query;
    private PreCheckoutQuery pre_checkout_query;
    private Poll poll;
    private PollAnswer poll_answer;
    private ChatMemberUpdated my_chat_member;
    private ChatMemberUpdated chat_member;
    private ChatJoinRequest chat_join_request;

    public TelegramBot(String botToken) {
    }

    public Integer updateId() {
        return update_id;
    }

    public Message message() {
        return message;
    }

    public Message editedMessage() {
        return edited_message;
    }

    public Message channelPost() {
        return channel_post;
    }

    public Message editedChannelPost() {
        return edited_channel_post;
    }

    public InlineQuery inlineQuery() {
        return inline_query;
    }

    public ChosenInlineResult chosenInlineResult() {
        return chosen_inline_result;
    }

    public CallbackQuery callbackQuery() {
        return callback_query;
    }

    public ShippingQuery shippingQuery() {
        return shipping_query;
    }

    public PreCheckoutQuery preCheckoutQuery() {
        return pre_checkout_query;
    }

    public Poll poll() {
        return poll;
    }

    public PollAnswer pollAnswer() {
        return poll_answer;
    }

    public ChatMemberUpdated myChatMember() {
        return my_chat_member;
    }

    public ChatMemberUpdated chatMember() {
        return chat_member;
    }

    public ChatJoinRequest chatJoinRequest() {
        return chat_join_request;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelegramBot that = (TelegramBot) o;
        return Objects.equals(update_id, that.update_id)
                && Objects.equals(message, that.message)
                && Objects.equals(edited_message, that.edited_message)
                && Objects.equals(channel_post, that.channel_post)
                && Objects.equals(edited_channel_post, that.edited_channel_post)
                && Objects.equals(inline_query, that.inline_query)
                && Objects.equals(chosen_inline_result, that.chosen_inline_result)
                && Objects.equals(callback_query, that.callback_query)
                && Objects.equals(shipping_query, that.shipping_query)
                && Objects.equals(pre_checkout_query, that.pre_checkout_query)
                && Objects.equals(poll, that.poll)
                && Objects.equals(poll_answer, that.poll_answer)
                && Objects.equals(my_chat_member, that.my_chat_member)
                && Objects.equals(chat_member, that.chat_member)
                && Objects.equals(chat_join_request, that.chat_join_request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(update_id, message,
                edited_message, channel_post,
                edited_channel_post, inline_query,
                chosen_inline_result, callback_query,
                shipping_query, pre_checkout_query,
                poll, poll_answer,
                my_chat_member, chat_member,
                chat_join_request);
    }

    @Override
    public String toString() {
        return "Update{" +
                "update_id=" + update_id +
                ", message=" + message +
                ", edited_message=" + edited_message +
                ", channel_post=" + channel_post +
                ", edited_channel_post=" + edited_channel_post +
                ", inline_query=" + inline_query +
                ", chosen_inline_result=" + chosen_inline_result +
                ", callback_query=" + callback_query +
                ", shipping_query=" + shipping_query +
                ", pre_checkout_query=" + pre_checkout_query +
                ", poll=" + poll +
                ", poll_answer=" + poll_answer +
                ", my_chat_member=" + my_chat_member +
                ", chat_member=" + chat_member +
                ", chat_join_request=" + chat_join_request +
                '}';
    }
}
