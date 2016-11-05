package com.example.zdeeo.exerciciolistjson.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zdeeo on 02/11/2016.
 */

public class Serie {
    @SerializedName("title")
    public String title;
//    @SerializedName("Year")
//    public String year;
//    @SerializedName("imdbID")
//    public String imdbId;
    @SerializedName("thumbnail")
    public String poster;
}
