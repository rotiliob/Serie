package com.example.zdeeo.exerciciolistjson.http;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.zdeeo.exerciciolistjson.model.Serie;

import java.io.IOException;
import java.util.List;

/**
 * Created by andre.burgos on 03/11/2016.
 */

public class SeriesSearchTask extends android.support.v4.content.AsyncTaskLoader<List<Serie>> {

    List<Serie> mSerie;
    String mQuery;
    public SeriesSearchTask(Context context, String q){
        super(context);
        mQuery = q;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (mQuery == null)return;
        if (mSerie == null){
            forceLoad();
        }else{
            deliverResult(mSerie);
        }

    }

    @Override
    public List<Serie> loadInBackground() {
        try {
            mSerie = SerieParser.searchByTitle(mQuery);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mSerie;
    }
}
