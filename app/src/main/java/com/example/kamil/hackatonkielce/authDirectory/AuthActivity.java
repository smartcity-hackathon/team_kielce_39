package com.example.kamil.hackatonkielce.authDirectory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.kamil.hackatonkielce.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthActivity extends AppCompatActivity {


    @BindView(R.id.passEditText)
    EditText passEditText;
    @BindView(R.id.emailEditText)
    EditText emailEditText;
    @BindView(R.id.loginButton)
    Button loginButton;
    @BindView(R.id.button2)
    Button registerButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);



    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);


    }


    }



