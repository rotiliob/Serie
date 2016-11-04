package com.example.zdeeo.exerciciolistjson;

import android.os.AsyncTask;
import android.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v4.app.LoaderManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.zdeeo.exerciciolistjson.http.SerieParser;
import com.example.zdeeo.exerciciolistjson.http.SeriesSearchTask;
import com.example.zdeeo.exerciciolistjson.model.Serie;
import com.example.zdeeo.exerciciolistjson.ui.adapter.SeriesAdapter;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Serie>>, SearchView.OnQueryTextListener {

    ListView mListSeries;
    LoaderManager loaderManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListSeries = (ListView)findViewById(R.id.list_series);

        loaderManager = getSupportLoaderManager();
        loaderManager.initLoader(0, null,this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public Loader<List<Serie>> onCreateLoader(int id, Bundle args) {
        String q = args != null ? args.getString("q") : null;
        return new SeriesSearchTask(this,q);
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

    @Override
    public boolean onQueryTextSubmit(String query) {
        Bundle bundle = new Bundle();
        bundle.putString("q",query);
        loaderManager.restartLoader(0, bundle,this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
