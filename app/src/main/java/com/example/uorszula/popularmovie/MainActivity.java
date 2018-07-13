package com.example.uorszula.popularmovie;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String datToSend = " Hello there" ;
    private Context context;
    private TextView text;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;
    private String urlTheMovieDB = "https://api.themoviedb.org/3/discover/movie?api_key=";
    private String auth = "";
    private GridView gridView;
    public static String[] eatFoodyImages = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        final String nameMovie = "Hello ";


        text = (TextView) findViewById(R.id.textViewTest);
        movies = new ArrayList<>();
        gridView = findViewById(R.id.gridviewmovie);

        movieAdapter = new MovieAdapter(MainActivity.this, R.layout.item_image, movies);
        Log.d("movieAdpater", movieAdapter.toString());
        gridView.setAdapter(movieAdapter);
        //ImageView view = findViewById(R.id.imageTest);
        //Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(view);


       /* gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, DetailMovie.class);
                intent.putExtra(Intent.EXTRA_TEXT, datToSend);
                //intent.putExtra("photo", eatFoodyImages[i]);
                //intent.putExtra("rate",)
                startActivity(intent);

            }
        });
*/
       makeQuery(auth);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            makeQuery(auth);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void makeQuery(String url) {
        String fullQuery = urlTheMovieDB + url;
        URL movieSearchUrl = NetworkUtils.buildUrl(fullQuery);
        new MovieLoader().execute(movieSearchUrl);
    }
    public class MovieLoader extends AsyncTask<URL, Void, Integer> {
        @Override
        protected Integer doInBackground(URL... urls) {
            Integer result = 0;
            URL searchUrl = urls[0];
            String movieSearchResult = null;
            try{
                movieSearchResult = NetworkUtils.getResponseFromHttpUrl(searchUrl);
                JsonUtils json = new JsonUtils();
                movies = json.parseMovieJson(movieSearchResult);
                if(movies != null) result = 1;
            }
            catch(IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
                Log.d("MainActivity", "Hello it's me");
                Log.d("Main Activity:", movies.get(1).toString());
                if(result ==1) {
                    movieAdapter.setData(movies);
                }
       }

}
}
