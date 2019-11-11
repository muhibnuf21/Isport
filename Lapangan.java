package com.example.isports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.text.SimpleDateFormat;

public class Lapangan {

    String tanggal;
    int jam=0;
    int jenis_olahraga;
    int jenis_olah;
    int ket=0;




    public Lapangan(int jenis_olahrg, int kete){
        this.tanggal=tanggal;
        this.jenis_olahraga=jenis_olahrg;
        this.jenis_olah=0;
        this.ket=kete;
    }

    public int getJenis_olahraga() {
        return jenis_olahraga;
    }
    public int getKet() {
        return ket;
    }


}
