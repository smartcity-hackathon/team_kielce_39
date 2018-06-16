package com.example.kamil.hackatonkielce.ReceiveDirectory.SingleItemDirectory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.kamil.hackatonkielce.R;

public class SingleItemActivity extends AppCompatActivity {

    TextView txt;
    Button btn;

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
        String descrptionString = (String)description;

        txt = (TextView) findViewById(R.id.textViewTitle);
        txt.setText("Tytuł: " + title);
        txt = (TextView) findViewById(R.id.textViewSalary);
        txt.setText("Kwota: " + sallary + "zł");
        txt = (TextView) findViewById(R.id.textContent);
        txt.setText(descrptionString);
        txt = (TextView) findViewById(R.id.textViewPhone);
        txt.setText("Numer telefonu: " + addPhoneNumber);



        Log.d("sth","jestem w single item "+ addPhoneNumber);

    }

}
