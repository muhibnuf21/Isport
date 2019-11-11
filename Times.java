package com.example.isports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.isports.Adapter.Dates;
import com.example.isports.Interface.TitleClickListener;
import com.example.isports.Model.Constants;

import java.util.ArrayList;


public class Times extends AppCompatActivity {

    private  static final String TAG = "Times";
    private Context mContext;

    ArrayList<String> titleList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times);

        mContext = Times.this;

        titleList = new ArrayList<String>();

        titleList = new ArrayList<>();
        titleList.add(Constants.TITLEA);
        titleList.add(Constants.TITLEB);
        titleList.add(Constants.TITLEC);
        titleList.add(Constants.TITLED);
        titleList.add(Constants.TITLEE);
        titleList.add(Constants.TITLEF);
        titleList.add(Constants.TITLEG);
        titleList.add(Constants.TITLEH);
        titleList.add(Constants.TITLEI);
        titleList.add(Constants.TITLEJ);

        recyclerView = (RecyclerView) findViewById(R.id.Listitemsview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager ( new LinearLayoutManager(getApplicationContext()));

        Dates adapter = new Dates(mContext, titleList, new TitleClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(mContext, "Selected" + ": " + titleList.get(position), Toast.LENGTH_SHORT).show();
            }

        });
        recyclerView.setAdapter(adapter);
    }}
