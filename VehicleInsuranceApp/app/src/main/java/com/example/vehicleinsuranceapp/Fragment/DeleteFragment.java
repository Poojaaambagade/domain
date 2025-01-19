package com.example.vehicleinsuranceapp.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vehicleinsuranceapp.R;
import com.example.vehicleinsuranceapp.database.AppDatabase;
import com.example.vehicleinsuranceapp.model.Claim;

import java.util.concurrent.Executors;

public class DeleteFragment extends Fragment {
    private EditText enterclaimId;
    private Button deleteBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        enterclaimId = (EditText) view.findViewById(R.id.enterDesId);
        deleteBtn = (Button) view.findViewById(R.id.deleteBtn);

        AppDatabase db = AppDatabase.getInstance(getContext());

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDeleteConfirmationDialog(db, enterclaimId);
            }
        });
        return  view;
    }

    private void showDeleteConfirmationDialog(AppDatabase db, EditText claimId){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete Confirmation");
        builder.setMessage("Are You Sure To Delete Claim?");

        int claimsId = Integer.parseInt(enterclaimId.getText().toString());

        builder.setPositiveButton("Delete", (dialog, which)->{

            Executors.newSingleThreadExecutor().execute(()-> {
                Claim claim = db.claimDao().getClaimById(claimsId);
                if(claim != null) {
                    db.claimDao().deleteClaim(claim);
                    getActivity().runOnUiThread(() -> {
                        Toast.makeText(getContext(), "Claim  delete successfully!", Toast.LENGTH_SHORT).show();

                        FragmentManager fragmentManager=getParentFragmentManager();
                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout,new DashboardFragment()).commit();

                    });
                }else {
                    getActivity().runOnUiThread(() -> {
                        Toast.makeText(getContext(), "Claim " + claimId + " not available !", Toast.LENGTH_SHORT).show();
                    });
                }
            });

        });

        builder.setNegativeButton("Cancel", (dialog,which)-> dialog.dismiss());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

}