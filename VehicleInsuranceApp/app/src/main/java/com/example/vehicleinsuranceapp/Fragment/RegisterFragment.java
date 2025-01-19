package com.example.vehicleinsuranceapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.vehicleinsuranceapp.R;

public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        EditText fName, LName;
        Button regBtn, bckBtn;

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        fName = view.findViewById(R.id.frag2NmaeId);
        LName = view.findViewById(R.id.frag2LastnameId);
        regBtn = view.findViewById(R.id.RegIdFraB);
        bckBtn = view.findViewById(R.id.backButton);

        bckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment firstFrag = new LoginFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,firstFrag).commit();
            }
        });

        return view;
    }

}