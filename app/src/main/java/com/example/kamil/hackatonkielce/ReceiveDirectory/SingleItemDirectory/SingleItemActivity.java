package com.example.kamil.hackatonkielce.ReceiveDirectory.SingleItemDirectory;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.kamil.hackatonkielce.R;

public class SingleItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item);

        Bundle extras = getIntent().getExtras();

        String addPhoneNumber = extras.getString("addPhoneNumber");
        String title = extras.getString("title");
        String sallary  = extras.getString("sallary");
        Object idOfPaidOffer = extras.getBundle("PaidOffer");
        Object description = extras.getBundle("desc");


        Log.d("sth","jestem w single item "+ addPhoneNumber);

    }

}
