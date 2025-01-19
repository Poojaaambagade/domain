package com.example.vehicleinsuranceapplicationnew;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

public class DashboardFragment extends Fragment {

    //private ClaimManagerService claimManagerService;
    private EditText entrdescription;
    private Button back, submit,update,delete,viewHistory;
    private ListView showListView;
    private ArrayAdapter<String> arrayAdaptor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        back = (Button) view.findViewById(R.id.backDash) ;
        entrdescription = (EditText) view.findViewById(R.id.DescriptionIdN);
        submit = (Button) view.findViewById(R.id.submitIdN);
        update = (Button) view.findViewById(R.id.updateIdN);
        delete = (Button) view.findViewById(R.id.deleteIdN);
        viewHistory = (Button) view.findViewById(R.id.historyIdN);
        showListView = (ListView) view.findViewById(R.id.listView);

        //claimManagerService = new ClaimManagerService();

        AppDatabase db = AppDatabase.getInstance(getContext());     // getContext()

        arrayAdaptor = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, new ArrayList<>());
        showListView.setAdapter(arrayAdaptor);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String descriptionNew = entrdescription.getText().toString();

                if(descriptionNew.isEmpty()){
                    Toast.makeText(getActivity(),"Please Filled Claim Description", Toast.LENGTH_SHORT).show();

                }else{

                   // String claimId = "ClaimId :"+(claimManagerService.getAllClaim().size()+1);

                    String dateSubmitted = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    String status = "pending";
                    String updatedDate = dateSubmitted;

                    Claim newClaim = new Claim(descriptionNew, status,dateSubmitted,updatedDate);

                    Executors.newSingleThreadExecutor().execute(()->{

                        db.claimDao().insertClaim(newClaim);
                    });

                    entrdescription.setText("");
                    Toast.makeText(getActivity(), "Claim Submitted Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });

        viewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> claimList = new ArrayList<>();

                Executors.newSingleThreadExecutor().execute(()->{

                    List<Claim> newClaimList = db.claimDao().getAllClaim();

                    getActivity().runOnUiThread(()->{

                        for(Claim claims : newClaimList){
                            claimList.add(claims.toString());
                        }

                        arrayAdaptor.clear();
                        arrayAdaptor.addAll(claimList);
                        arrayAdaptor.notifyDataSetChanged();
                    });
                });
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new LoginFragment()).commit();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new DeleteFragment()).commit();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new UpdateFragment()).commit();
            }
        });


        return view;
    }
}