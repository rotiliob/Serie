package com.example.zdeeo.exerciciolistjson.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zdeeo on 02/11/2016.
 */

public class Series {
    @SerializedName("Title")
    public String title;
    @SerializedName("Year")
    public String year;
    @SerializedName("imdbID")
    public String imdbId;
    @SerializedName("Poster")
    public String poster;
}
