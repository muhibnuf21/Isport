package com.example.isports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.isports.Adapter.MyTimeSlot;
import com.example.isports.Interface.ITimeSlotLoadListener;
import com.example.isports.Model.TimeSlotView;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;

import java.util.List;

public class TimeLoad extends AppCompatActivity implements ITimeSlotLoadListener {


    ITimeSlotLoadListener iTimeSlotLoadListener;
    AlertDialog dialog;

    RecyclerView time_slot;

    BroadcastReceiver timeslotview = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };

    private void setiTimeSlotLoadListener(String slotId) {
        dialog.show();
    }
    static TimeLoad instance;
    public static TimeLoad getInstance() {
        if (instance == null)
            instance = new TimeLoad();
        return instance;
    }

    private  static final String TAG = "Times";
        private Context mContext;

        List<MyTimeSlot> titleList;
        private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_load);

        iTimeSlotLoadListener =this;
        mContext = TimeLoad.this;


            recyclerView = (RecyclerView) findViewById(R.id.Listitemsview);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager ( new LinearLayoutManager(getApplicationContext()));

            MyTimeSlot adapter = new MyTimeSlot(mContext) {


            };
            recyclerView.setAdapter(adapter);
        }
    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemview = inflater.inflate(R.layout.activity_time_load,container,false);
        init(itemview);

        return itemview;

    }
    private void init(View itemview) {
        time_slot.setHasFixedSize(true);

    }

    @Override
    public void onTimeSlotLoadSuccess(List<TimeSlotView> timeSlotList) {
        MyTimeSlot adapter = new MyTimeSlot(getBaseContext(), timeSlotList);
        time_slot.setAdapter(adapter);
        
        dialog.dismiss();

    }

    @Override
    public void onTimeSlotLoadFailed(String message) {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
        dialog.dismiss();


    }

    @Override
    public void onTimeSlotLoadempty() {
        MyTimeSlot adapter = new MyTimeSlot(getBaseContext());
        time_slot.setAdapter(adapter);

        dialog.dismiss();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}