package com.example.kamil.hackatonkielce;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GiveActivity extends AppCompatActivity {

    EditText addTitle;
    EditText addSalary;
    EditText textContent;
    EditText addPhoneNumber;

    Button button;
    Button buttonAddReport;

    DatabaseReference raportDatabase;


//test
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give);

        raportDatabase = FirebaseDatabase.getInstance().getReference("AddingOfferts");

        button = (Button) findViewById(R.id.photoButton);
        Typeface fontOfButtons = Typeface.createFromAsset(getAssets(),"fonts/Bold.ttf");
        button.setTypeface(fontOfButtons);
        button = (Button) findViewById(R.id.buttonLocalization);
        Typeface fontOfButtons2 = Typeface.createFromAsset(getAssets(),"fonts/Bold.ttf");
        button.setTypeface(fontOfButtons);
        button = (Button) findViewById(R.id.buttonAccept);
        Typeface fontOfButtons3 = Typeface.createFromAsset(getAssets(),"fonts/Bold.ttf");
        button.setTypeface(fontOfButtons);

        buttonAddReport = (Button) findViewById(R.id.buttonAccept);
        addTitle = (EditText) findViewById(R.id.addTitle);
        addSalary = (EditText) findViewById(R.id.addSalary);
        button = (Button) findViewById(R.id.photoButton);
        textContent = (EditText) findViewById(R.id.textContent);
        addPhoneNumber = (EditText) findViewById(R.id.addPhoneNumber);

        buttonAddReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                text = editText.getText().toString();
//                Intent toy = new Intent(edmt.dev.androidgridlayout.ActivitySecondSettings.this, ActivitySecondWorkers.class);
//                startActivity(toy);
                addReport();
            }
        });


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
//        button = (Button) findViewById(R.id.buttonAccept);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(GiveActivity.this, "Twoje ogłoszenie dodano do bazy!", Toast.LENGTH_SHORT).show();
//
//            }
//        });



    }
    private void addReport(){
          String title = addTitle.getText().toString().trim();
          String sallary = addSalary.getText().toString();
          String description = textContent.getText().toString();
          String number = addPhoneNumber.getText().toString();

        if(!TextUtils.isEmpty(title)){

            String id = raportDatabase.push().getKey();
            PaidOffers reports = new PaidOffers(id,title,sallary,description,number);
            raportDatabase.child(id).setValue(reports);
            Toast.makeText(this,"Dodano raport, dziękujemy.",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this,"Wprowadź dane!", Toast.LENGTH_LONG).show();
        }
    }
}
