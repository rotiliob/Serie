package com.example.zdeeo.exerciciolistjson;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.zdeeo.exerciciolistjson.http.SerieParser;
import com.example.zdeeo.exerciciolistjson.model.Serie;
import com.example.zdeeo.exerciciolistjson.ui.adapter.SeriesAdapter;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListSeries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListSeries = (ListView)findViewById(R.id.list_series);

        new SerieSearchTask().execute("Batman");
    }
   class SerieSearchTask extends AsyncTask<String, Void, List<Serie>>{

       @Override
       protected List<Serie> doInBackground(String... params) {
           try {
               List<Serie> series = SerieParser.searchByTitle(params[0]);

               return series;
           } catch (IOException e) {
               e.printStackTrace();
           }
           return null;
       }

       @Override
       protected void onPostExecute(List<Serie> series) {
           super.onPostExecute(series);
           if (series != null) {
               mListSeries.setAdapter(new SeriesAdapter(MainActivity.this, series));
           }
       }
   }
}
