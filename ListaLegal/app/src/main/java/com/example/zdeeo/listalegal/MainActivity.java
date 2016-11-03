package com.example.zdeeo.listalegal;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zdeeo.listalegal.http.SeriesParser;
import com.example.zdeeo.listalegal.model.Series;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new SeriesSearchTask().execute("Batman");
    }

    class SeriesSearchTask extends AsyncTask <String, Void , List<Series>>{

        @Override
        protected List<Series> doInBackground(String... params) {

            try {
                List<Series> series = null;

                series = SeriesParser.searchByTitle(params[0]);
                for (Series serie: series) {
                    Log.d("NGVL","Series------>"+ serie.title);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
