package com.example.vehicleinsuranceapplicationnew;

import static android.content.Context.NOTIFICATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;

public class UpdateFragment extends Fragment {

    private EditText entrClaimId, etnewStatus;
    Button updateBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_update, container, false);

        entrClaimId = (EditText) view.findViewById(R.id.entrClaimIdNv);
        etnewStatus = (EditText) view.findViewById(R.id.updateStatusNv);
        updateBtn = (Button) view.findViewById(R.id.updateBtnNv);

        AppDatabase db = AppDatabase.getInstance(getContext());

        updateBtn.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("NotificationPermission")
            @Override
            public void onClick(View v) {

                int claimId = Integer.parseInt(entrClaimId.getText().toString());
                String newStatus = etnewStatus.getText().toString();
                String updatedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                // Update the claim status
                // claimManager.updateClaimStatus(claimId, newStatus, updatedDate);

                Executors.newSingleThreadExecutor().execute(()-> {
                    Claim existingClaim = db.claimDao().getClaimById(claimId);
                    if (existingClaim != null) {
                        existingClaim.setStatus(newStatus);
                        existingClaim.setDateUpdated(updatedDate);
                        db.claimDao().updateClaim(existingClaim);
                        getActivity().runOnUiThread(() -> {

                            // Send a notification when the claim is updated

//                            NotificationHelper.sendNotification(getApplicationContext(), existingClaim.getStatus());

                            Toast.makeText(getContext(), "Claim Status Updated: " + existingClaim.getStatus(), Toast.LENGTH_SHORT).show();

                            // Toast.makeText(UpdateClaimStatusActivity.this, "Claim status updated", Toast.LENGTH_SHORT).show();

                            FragmentManager fragmentManager = getParentFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frame_layout, new DashboardFragment()).commit();

                            NotificationHelper.sendNotification(requireContext(), existingClaim.getStatus());

                        });

                    } else {
                        requireActivity().runOnUiThread(() -> {
                            Toast.makeText(getContext(), "Claim " + claimId + " not available !", Toast.LENGTH_SHORT).show();

                            FragmentManager fragmentManager = getParentFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frame_layout, new DashboardFragment()).commit();
                        });
                    }

                });

            }

        });

        return view;

    }
}