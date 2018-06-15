package com.example.kamil.hackatonkielce;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kamil.hackatonkielce.GiveActivity;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.ArrayList;


public class ReceiveActivity extends AppCompatActivity {

    private Firebase mref1;

    private String url;

    private ListView mListView;

    private ArrayList<String> mWydzialy = new ArrayList<>();

    public static int zmiennaDoPrzekazaniaWFourthOffer;

    TextView t;

    Button button;

    public static int hehe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);


        button = (Button) findViewById(R.id.buttonLocation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // = 0;
                Intent toy = new Intent(ReceiveActivity.this, FromReceiveActivityLocation.class);
                startActivity(toy);
            }
        });
        button = (Button) findViewById(R.id.buttonFilter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ReceiveActivity.this, "Tu nam sie sortuje baza", Toast.LENGTH_SHORT).show();

            }
        });



        t = (TextView) findViewById(R.id.textView1);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf");
        t.setTypeface(myCustomFont);


        Firebase.setAndroidContext(this);

        setUrl("https://androidhack-e4f9d.firebaseio.com/");


        mref1 = new Firebase(getUrl());

        mListView = (ListView) findViewById(R.id.listVieww);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,mWydzialy);
        mListView.setAdapter(arrayAdapter);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position==0){
                        Toast.makeText(ReceiveActivity.this, "Zrob zdjecie/wybierz z galerii", Toast.LENGTH_SHORT).show();
                        zmiennaDoPrzekazaniaWFourthOffer = 0;
                    }
                    if(position ==1){
                        Toast.makeText(ReceiveActivity.this, "Zrob zdjecie/wybierz z galerii", Toast.LENGTH_SHORT).show();
                        zmiennaDoPrzekazaniaWFourthOffer = 1;
                    }
                    if(position==2){
                        Toast.makeText(ReceiveActivity.this, "Zrob zdjecie/wybierz z galerii", Toast.LENGTH_SHORT).show();
                        zmiennaDoPrzekazaniaWFourthOffer = 2;
                    }
                    if(position ==3){
                        Toast.makeText(ReceiveActivity.this, "Zrob zdjecie/wybierz z galerii", Toast.LENGTH_SHORT).show();
                        zmiennaDoPrzekazaniaWFourthOffer = 3;

                    }
                    if(position==4){
                        Toast.makeText(ReceiveActivity.this, "Zrob zdjecie/wybierz z galerii", Toast.LENGTH_SHORT).show();
                        zmiennaDoPrzekazaniaWFourthOffer = 4;
                    }

                    if(position ==5){
                        Toast.makeText(ReceiveActivity.this, "Zrob zdjecie/wybierz z galerii", Toast.LENGTH_SHORT).show();

                        zmiennaDoPrzekazaniaWFourthOffer = 5;
                    }
                    if(position==6){
                        Toast.makeText(ReceiveActivity.this, "Zrob zdjecie/wybierz z galerii", Toast.LENGTH_SHORT).show();

                        zmiennaDoPrzekazaniaWFourthOffer = 6;

                    }
                    if(position ==7){
                        Toast.makeText(ReceiveActivity.this, "Zrob zdjecie/wybierz z galerii", Toast.LENGTH_SHORT).show();

                        zmiennaDoPrzekazaniaWFourthOffer = 7;


                    }

                }
            });


        mref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //String value = dataSnapshot.getValue(String.class);
                String value = String.valueOf(dataSnapshot.getValue());
                mWydzialy.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



//        abuttonDodaj = (Button) findViewById(R.id.buttonDodaj);
//        abuttonDodaj.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//
//                Firebase mRefChild = mref.child("Name");
//                mRefChild.setValue("Goeff");
//            }
//
//        });

    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
