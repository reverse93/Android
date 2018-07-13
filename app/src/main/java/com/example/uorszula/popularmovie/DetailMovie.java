package com.example.uorszula.popularmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetailMovie extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    public String titleName;
    private TextView title;
    private TextView rate;
    private TextView dateRelease;
    private ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        Intent intentThatStartedThisActivity = getIntent();
        title = findViewById(R.id.title);
        imageview = findViewById(R.id.movie);

        if(intentThatStartedThisActivity != null){
            if(intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)){
                titleName = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
                title.setText(titleName);
            }
        }

        if(intentThatStartedThisActivity != null){
            if(intentThatStartedThisActivity.hasExtra("photo")){
                String imagePhoto = intentThatStartedThisActivity.getStringExtra("photo");
                Picasso.with(this).load(imagePhoto).into(imageview);
            }
        }
    }

}
