package com.example.testingapps;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*

 Ada 3 Tipe Bug
 1. Bug Force Closed : dikarenakan
                    -Java Null Pointer Exception (objek yangg diambil masih null)
                    -Java Out of Memory Exception (kelebihan memori)
                    -Java Index Out of Bound  (mengakses indeks diluar jangkauan)
                    -Java Memory Leak (Memori pengguna tidak memadai)
 2. Bug Not Responding : Proses yang berjalan di main Thread tidak berjalan selama 5 detik
 3. Bug Miss Logic : kesalahan logika pada kode
*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSetNilai;
    private TextView tvText;
    private ArrayList<String> names;
    private DelayAsync delayAsync; //
    ImageView PhotoGunung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.setNilai);
        btnSetNilai = findViewById(R.id.clickMe);
        PhotoGunung = findViewById(R.id.img_value);
        PhotoGunung.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.fronalpstock_big));

        btnSetNilai.setOnClickListener(this);
        names = new ArrayList<>();
        names.add("Fauzan Ramadhan");// add data ga dari string
        names.add("zara");
        names.add("ojan");
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.clickMe){
            //tvText.setText("19");//Error karena belum di inisiasi
            StringBuilder name = new StringBuilder(); //
            for (int i = 0 ; i < names.size();i++){
                name.append(names.get(i)).append("\n"); //
            }
            Glide.with(this).load(R.drawable.fronalpstock_big).into(PhotoGunung);//memperkecil ukuran gambar

            tvText.setText(name.toString());

            delayAsync = new DelayAsync(); //
            delayAsync.execute();

        }
    }

    private class DelayAsync extends AsyncTask implements com.example.testingapps.DelayAsync {
        @Override
        protected Object doInBackground(Object[] objects) {//
            try {
            Thread.sleep(300000);//Stack buttonnya gabisa di pencet
            //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            return null;
        }

        @Override
        public void onPostExecute(Void aVoid) {//
            super.onPostExecute(aVoid);
            Log.d("DelayASync","Done");
        }

        @Override
        protected void onCancelled() {//
            super.onCancelled();
            Log.d("DelayASync","Cancelled");

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(delayAsync != null){
            if (delayAsync.getStatus().equals(AsyncTask.Status.RUNNING)){
                delayAsync.cancel(true);
            }
        }
    }
}
