package com.example.kamil.hackatonkielce;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GiveActivity extends AppCompatActivity {

    EditText editText;
    Button button;
//test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give);
        editText = (EditText) findViewById(R.id.addTitle);
        editText = (EditText) findViewById(R.id.addSalary);



        button = (Button) findViewById(R.id.photoButton);
        Typeface fontOfButtons = Typeface.createFromAsset(getAssets(),"fonts/Bold.ttf");
        button.setTypeface(fontOfButtons);
        button = (Button) findViewById(R.id.buttonLocalization);
        Typeface fontOfButtons2 = Typeface.createFromAsset(getAssets(),"fonts/Bold.ttf");
        button.setTypeface(fontOfButtons);
        button = (Button) findViewById(R.id.buttonAccept);
        Typeface fontOfButtons3 = Typeface.createFromAsset(getAssets(),"fonts/Bold.ttf");
        button.setTypeface(fontOfButtons);


        button = (Button) findViewById(R.id.photoButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tutaj bedzie otwarcie do wybrania zdjecia albo do zrobienia zdjecia
                Toast.makeText(GiveActivity.this, "Zrob zdjecie/wybierz z galerii", Toast.LENGTH_SHORT).show();

            }
        });
        button = (Button) findViewById(R.id.buttonLocalization);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toy = new Intent(GiveActivity.this, FromGiveActivityToLocation.class);
                startActivity(toy);
            }
        });
        button = (Button) findViewById(R.id.buttonAccept);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(GiveActivity.this, "Twoje ogłoszenie dodano do bazy!", Toast.LENGTH_SHORT).show();

            }
        });



    }
}
