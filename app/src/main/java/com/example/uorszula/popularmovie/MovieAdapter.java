package com.example.uorszula.popularmovie;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList<Movie> mMovieData;
    private String[] food;
    private String BASE_LINK = "http://image.tmdb.org/t/p/w185/";
    public MovieAdapter(Context context, int layoutResourceId, ArrayList<Movie> movies)
    {

        super(context, layoutResourceId, movies);
        this.mMovieData = movies;
        this.layoutResourceId = layoutResourceId;
        this.mMovieData = movies;
        this.context = context;
    }

    public void setData(ArrayList<Movie> movieData) {
       // Log.d("HELLO THERE", mMovieData.get(1).toString());
        this.mMovieData = movieData;
        //Log.d("MovieAdapter",mMovieData.get(1).getImageMv().toString());
        notifyDataSetChanged();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageView = row.findViewById(R.id.imageView);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        Movie currentMovie = mMovieData.get(position);
        Log.d("check url link",currentMovie.toString());

        Picasso.with(context).load(BASE_LINK + currentMovie.getImageMv()).into(holder.imageView);
        return row;
    }

    static class ViewHolder{
        ImageView imageView;
    }
}
