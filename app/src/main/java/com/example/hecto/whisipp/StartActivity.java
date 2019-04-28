package com.example.hecto.whisipp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    Button login,register;

    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();

        firebaseUser =FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null){
            Intent intent = new Intent(StartActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        if (firebaseUser != null){
            Intent intent = new Intent(StartActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

            //Bindings
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.btn_Register);

     login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startActivity(new Intent(StartActivity.this, LoginActivity.class));
         }
     });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, RegisterActivity.class));
            }
        });




    }
}
