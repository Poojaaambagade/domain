package com.example.vehicleinsuranceapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vehicleinsuranceapp.R;

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        EditText userText, passText;
        Button loginButton, registerBtn;
        TextView msgText;

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        userText = view.findViewById(R.id.usertextfrag1);
        passText = view.findViewById(R.id.passwordtextfrag1);
        loginButton = view.findViewById(R.id.loginBFrag1);
        registerBtn = view.findViewById(R.id.regBFrag1N);

        // code for bundles

//        Intent intent = new Intent(LoginFragment.this, DashboardFragment.class);  // navigate through activity to act using Intent
//        intent.putExtra("Username :", userText.getText().toString());  // bundles
//
//        Bundle bundle = getIntent().getExtras();    //if complex obj create separate bundle object
//        bundle.putString("password", passText.getText().toString());
//        startActivity(intent);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String enterUser = userText.getText().toString().trim();
                String enterPass = passText.getText().toString().trim();


                if (enterUser.isEmpty() || enterPass.isEmpty()) {

                    Toast.makeText(getContext(), "Please Fill Both Fields", Toast.LENGTH_SHORT).show();
                    //return;
                }
                if (enterUser.equals("admin") && enterPass.equals("admin")){

                    Toast.makeText(getContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(getContext(),"Failed To Login",Toast.LENGTH_SHORT).show();
                }

                Fragment thirdFrag = new DashboardFragment();             // thirdFrag --> dashboardFrag
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, thirdFrag).commit();

//                FragmentManager fragmentManager=getParentFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.frame_layout,new DashboardFragment()).commit();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                FragmentManager fragmentManager=getParentFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.frame_layout,new RegisterFragment()).commit();

                Fragment secondFrag = new RegisterFragment();       // secondFrag --> regFrag
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,secondFrag).commit();
            }
        });

        return view;
    }

}