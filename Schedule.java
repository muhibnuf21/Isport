package com.example.isports;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isports.Adapter.Dates;
import com.example.isports.Adapter.MyTimeSlot;
import com.example.isports.Fragments.TimesFragment;
import com.google.firebase.database.DatabaseReference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static java.security.AccessController.getContext;

public class Schedule extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    ImageButton txt_tgl;
    ImageButton btn_schedule;
    String jensol;
    String tggl;
    int jenis_olahraga;
    int jampes;
    int ketepes;
    DatabaseReference dblapangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Spinner spinner = findViewById(R.id.spinners);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.number, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        txt_tgl = (ImageButton) findViewById(R.id.schedule_icon);
        btn_schedule = (ImageButton) findViewById(R.id.checknow);

        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        txt_tgl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Schedule.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        btn_schedule.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                 String id= tggl;

                if (jensol.equals("Badminton")){
                    jenis_olahraga=1;
                }
                if (jensol.equals("Volly")){
                    jenis_olahraga=2;
                }
                if (jensol.equals("Futsal")){
                    jenis_olahraga=3;
                }

                String shiftpesx=Integer.toString(jampes);

                Lapangan lp= new Lapangan(jenis_olahraga, ketepes );


                dblapangan.child(id).child(shiftpesx).setValue(lp);

                Intent balik = new Intent(Schedule.this, Menu.class);
                startActivity(balik);

                Toast.makeText(Schedule.this, "Lapangan telah terpesan",Toast.LENGTH_LONG).show();

            }
        });

            }



    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txt_tgl.getContext();
        tggl = sdf.format(myCalendar.getTime());
        Log.d("ADebugTag","Value:"+tggl);
    }

    public void btn_zoomout(View view) {
        Intent Uncheck = new Intent(getApplicationContext(), Menu.class);
        startActivity(Uncheck);
    }

    public void btn_time(View view) {
        Intent Times = new Intent(getApplicationContext(), TimeLoad.class);
        startActivity(Times);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
