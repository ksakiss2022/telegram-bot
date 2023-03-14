package pro.sky.telegrambot.model;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.impl.UpdatesHandler;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import com.sun.istack.Builder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Objects;

public class TelegramBot {
    //implements Serializable
    private final String token;
    private final TelegramBotClient api;
    private final FileApi fileApi;
    private final UpdatesHandler updatesHandler;

    public TelegramBot(String token, TelegramBotClient api, FileApi fileApi, UpdatesHandler updatesHandler) {
        this.token = token;
        this.api = api;
        this.fileApi = fileApi;
        this.updatesHandler = updatesHandler;
    }
//    public TelegramBot(String botToken) {
//        this(new Builder() {
//            @Override
//            public Object build() {
//                return null;
//            }
//        });
//    }

//    TelegramBot(Builder builder) {
//        this.token = builder.botToken;
//        this.api = builder.api;
//        this.fileApi = builder.fileApi;
//        this.updatesHandler = builder.updatesHandler;
//    }
    public <T extends BaseRequest<T,R>,R extends BaseResponse> R execute(BaseRequest<T,R>request){
        return api.send(request);
    }

    public <T extends BaseRequest<T,R>, R extends BaseResponse> void execute (T request, Callback<T,R> callback){
        api.send(request,callback);
    }

    public String getToken(){
        return token;
    }

    public String getFullFilePath(File file){
        return fileApi.getFullFilePath(file.filePath());
    }

//    public byte[] getFileContent(File file) throws IOException {
//        String fileUrl = getFullFilePath(file);
//        URLConnection connection = new URL(fileUrl).openConnection();
//        try (InputStream is = connection.getInputStream()) {
//
//        }
//    }
}
