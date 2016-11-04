package com.example.zdeeo.exerciciolistjson;

import android.os.AsyncTask;
import android.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;

import com.example.zdeeo.exerciciolistjson.http.SerieParser;
import com.example.zdeeo.exerciciolistjson.http.SeriesSearchTask;
import com.example.zdeeo.exerciciolistjson.model.Serie;
import com.example.zdeeo.exerciciolistjson.ui.adapter.SeriesAdapter;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Serie>> {

    ListView mListSeries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListSeries = (ListView)findViewById(R.id.list_series);

        LoaderManager lm = getSupportLoaderManager();
        lm.initLoader(0, null,this);
    }

    @Override
    public Loader<List<Serie>> onCreateLoader(int id, Bundle args) {
        return new SeriesSearchTask(this,"Batman");
    }

    @Override
    public void onLoadFinished(Loader<List<Serie>> loader, List<Serie> data) {
        if (data != null) {
            mListSeries.setAdapter(new SeriesAdapter(MainActivity.this, data));
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Serie>> loader) {
    }
}
