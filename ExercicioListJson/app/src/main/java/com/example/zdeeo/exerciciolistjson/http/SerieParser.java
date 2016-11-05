package com.example.zdeeo.exerciciolistjson.http;

import com.example.zdeeo.exerciciolistjson.model.Serie;
import com.example.zdeeo.exerciciolistjson.model.SerieSearchResult;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zdeeo on 02/11/2016.
 */

public class SerieParser {
    public static final String URL_SEARCH = "http://www.recipepuppy.com/api/?q=%s";

    public static List<Serie> searchByTitle(String q) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(String.format(URL_SEARCH, q)).build();

        Response response = client.newCall(request).execute();
        if (response.networkResponse().code() == HttpURLConnection.HTTP_OK) {
            String json = response.body().string();

            Gson gson = new Gson();
            SerieSearchResult result =
                    gson.fromJson(json, SerieSearchResult.class);
            if (result != null) {
                return result.series;
            }
        }
        return null;
    }
}
