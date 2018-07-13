package com.example.uorszula.popularmovie;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static ArrayList<Movie> parseMovieJson(String json) throws JSONException{
        JSONObject movie = new JSONObject(json);
        ArrayList<Movie> movies = new ArrayList<>();
        String title = null;
        String image = null;
        String rate = null;
        String date = null;

        try {
            JSONArray movieObject = movie.getJSONArray("results");

            for(int i = 0; i<movieObject.length();i++){
                JSONObject currentMovie = movieObject.getJSONObject(i);

                if (currentMovie.has("title")) {
                    title = currentMovie.getString("title");
                } else title = "no title";
                if (currentMovie.has("poster_path")) {
                    image = currentMovie.getString("poster_path");
                } else image = " ";
                if (currentMovie.has("vote_average")) {
                    rate = currentMovie.getString("vote_average");
                } else rate = "no rate";
                if (currentMovie.has("release_date")) {
                    date = currentMovie.getString("release_date");
                } else date = "no date";

            Movie movieObjectAll = new Movie(image, title, date, rate);
            Log.d("Json parser", image + title + rate + date);
            movies.add(movieObjectAll);
            }
        }
        catch(JSONException e){
            Log.e("JsonUtils", "Problem with parsing json", e);
        }
        return movies;
    }
}
