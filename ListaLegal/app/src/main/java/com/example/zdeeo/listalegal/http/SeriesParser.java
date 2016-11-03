package com.example.zdeeo.listalegal.http;

import com.example.zdeeo.listalegal.model.Series;
import com.example.zdeeo.listalegal.model.SeriesSearchResult;
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

public class SeriesParser {

    public static final String URL_SEARCH = "http://www.omdbapi.com/?s=%s&page=2";

    public static List<Series> searchByTitle(String q) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(String.format(URL_SEARCH, q)).build();

        Response response = client.newCall(request).execute();
        if (response.networkResponse().code() == HttpURLConnection.HTTP_OK) {
            String json = response.body().string();

            Gson gson = new Gson();
            SeriesSearchResult result = gson.fromJson(json, SeriesSearchResult.class);
            
            if (result != null) {
                return result.series;
            }
        }
        return null;
    }
}
