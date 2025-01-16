package com.example.bokklending;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        EditText user = findViewById(R.id.userId);
//        EditText password = findViewById(R.id.passId);
//        Button login = findViewById(R.id.buttonId);
//        TextView textViewNew = findViewById(R.id.textViewId);
//        Button regButton = findViewById(R.id.buttonReg);

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(user.getText().toString().equalsIgnoreCase("admin") && password.getText().toString().equalsIgnoreCase("admin")){
//
//                    textViewNew.setText("success");
//                }else{
//                    textViewNew.setText("failure");
//                }
//
//            }
//        });
//        regButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//        });

        Button b1 = findViewById(R.id.fragment1Button);
        Button b2 = findViewById(R.id.fragment2Button);

        loadFragment(new FragAFragment());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Fragment());


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FragAFragment());
            }
        });
    }

    public void loadFragment(Fragment fragment){

        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager1.beginTransaction();
        ft.add(R.id.containerNew,new FragAFragment());
        ft.commit();
    }
}