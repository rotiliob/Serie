package com.example.zdeeo.exerciciolistjson.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zdeeo on 02/11/2016.
 */

public class SerieSearchResult {
    @SerializedName("results")
    public List<Serie> series;
}
