package com.example.alejandroo.userprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private Profile profile;
    private  ImageView backgroundview;
   private  ImageView profileview;

   private TextView nameview;
    private TextView handleview;
    private TextView followingview;
    private TextView followersview;
    private TextView aboutmeview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            InputStream stream = getAssets().open("alejandro.json");
            InputStreamReader reader = new InputStreamReader(stream);
            Gson gson = new Gson();
            profile = gson.fromJson(reader, Profile.class);
        }
    catch (IOException e){
        Toast.makeText(this, "No he pogut llegir el fitxer", Toast.LENGTH_SHORT).show();

    }

    nameview = findViewById(R.id.nameview);
        handleview = findViewById(R.id.handleview);
        followingview = findViewById(R.id.followingview);
        followersview = findViewById(R.id.followersview);
        aboutmeview = findViewById(R.id.aboutmeview);

    nameview.setText(profile.getName());
    handleview.setText(profile.getHandle());
    followingview.setText(profile.getFollowing());
    followersview.setText(profile.getFollowers());
    aboutmeview.setText(profile.getAbout());

    backgroundview= findViewById(R.id.backgroundview);
    Glide.with(this).load("file:///android_asset/background.png")
            .into(backgroundview);



    profileview = findViewById(R.id.profileview);
    Glide.with(this)
        .load("file:///android_asset/profile.png")
            .apply(RequestOptions.circleCropTransform())
            .into(profileview);



    }
}
