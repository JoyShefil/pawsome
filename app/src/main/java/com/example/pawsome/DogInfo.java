package com.example.pawsome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class DogInfo extends AppCompatActivity {
    ImageView mDogPic;
    TextView mName,mTemperament,mLife_span,mOrigin,mWeight,mHeight,mAlt_names,mWiki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_info);
        mDogPic = findViewById(R.id.dogPic);
        mName = findViewById(R.id.name);
        mTemperament = findViewById(R.id.Temperament);
        mLife_span = findViewById(R.id.life);
        mOrigin = findViewById(R.id.origin);
        mWeight = findViewById(R.id.weight);
        mHeight = findViewById(R.id.height);
        mAlt_names = findViewById(R.id.Alt_names);
        mWiki = findViewById(R.id.wiki);

        Intent intent = getIntent();
        String image = intent.getStringExtra("Image");
        String Name = intent.getStringExtra("Name");
        String Temperament = intent.getStringExtra("Temperament");
        String Life_span = intent.getStringExtra("Life_span");
        String Origin = intent.getStringExtra("Origin");
        String Weight = intent.getStringExtra("Weight");
        String Height = intent.getStringExtra("Height");
        String Alt_names = intent.getStringExtra("Alt_names");
        String Wiki = intent.getStringExtra("Wiki");


        mName.setText(Name);
        Picasso.get().load(image).centerCrop().resize(300,300).into(mDogPic);
        mTemperament.setText("Temperament: "+Temperament);
        mLife_span.setText("Life Span: "+Life_span);
        mOrigin.setText("Origin: "+Origin);
        mWeight.setText("Weight: "+Weight + " pounds");
        mHeight.setText("Height: "+Height + " inches");
        mAlt_names.setText(Alt_names);
        mWiki.setText(Wiki);
    }
}