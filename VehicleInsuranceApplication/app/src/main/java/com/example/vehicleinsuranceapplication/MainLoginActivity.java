package com.example.vehicleinsuranceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });



        EditText email = findViewById(R.id.emailId);
        EditText password = findViewById(R.id.passId);
        Button login = findViewById(R.id.loginId);
        TextView textHeader = findViewById(R.id.headerId);
        TextView msgTextOnButton = findViewById(R.id.textVId);
        Button register = findViewById(R.id.regId);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString().equalsIgnoreCase("admin") && password.getText().toString().equalsIgnoreCase("admin")){

                    msgTextOnButton.setText("Success");

                }else{
                    msgTextOnButton.setText("Failure");
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentRegister = new Intent(MainLoginActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
            }
        });



    }
}