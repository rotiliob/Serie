package com.example.zdeeo.exerciciolistjson.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zdeeo.exerciciolistjson.R;
import com.example.zdeeo.exerciciolistjson.model.Serie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by andre on 03/11/2016.
 */

public class SeriesAdapter extends ArrayAdapter<Serie>{

    public SeriesAdapter(Context context, List<Serie> series) {
        super(context,0, series);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Serie serie = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_serie, parent, false);
        }
        ImageView imgPoster = (ImageView)convertView.findViewById(R.id.item_serie_poster);
        TextView txtTitle = (TextView)convertView.findViewById(R.id.item_serie_title);
        TextView txtYear = (TextView)convertView.findViewById(R.id.item_serie_year);

        Picasso.with(getContext())
                .load(serie.poster)
                .into(imgPoster);
        txtTitle.setText(serie.title);
        txtYear.setText(serie.year);
        return convertView;
    }
}
