package com.example.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements AsyncCallBack{
    TextView textStatus;
    TextView textDesc;

    private final String INPUT_STRING ="Halo ini demo ASYNC TASK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textDesc = findViewById(R.id.idDesc);
        textStatus = findViewById(R.id.idStatus);

        DemoAsync   demoAsync = new DemoAsync(this);
        demoAsync.execute(INPUT_STRING); //  memantau penggunaan asynctask dengan textview
    }

    @Override
    public void onPreExecute() {
        textStatus.setText(R.string.status_pre);
        textDesc.setText(INPUT_STRING);
    }

    @Override
    public void onPostExecute(String result) {
        textStatus.setText(R.string.status_post);
        if (result != null) {
            textDesc.setText(result);
        }
    }

    private static class DemoAsync extends AsyncTask<String,Void,String> {
        static final String LOG_ASYNC = "DemoAsync";
        WeakReference<AsyncCallBack> mListener; // untuk menghubungkan sebuah kelas dengan kelas lain dengan bantuan sebuah kelas interface sebagai callback.
        //mengisi status yang ada pada bagian callback tersebut
        DemoAsync(AsyncCallBack mListener){
            this.mListener = new WeakReference<>(mListener);
        }
        @Override
        protected void onPreExecute() { // persiapan asynctask saat masih di main Thread
            super.onPreExecute();
            Log.d(LOG_ASYNC,"Status : onPreExecute");

            AsyncCallBack mListener = this.mListener.get();
            if (mListener != null){
                mListener.onPreExecute();
            }
        }

        @Override
        protected String doInBackground(String... params) {//menunjukkan bahwa inputan dari sebuah AsyncTask bisa lebih dari satu.
            Log.d(LOG_ASYNC,"Status : doInBackGround");
            String output = null;
            try {
                String input = params[0]; // params menerima string
                output = input + " Selamat Belajar";
                Thread.sleep(2000); /// delay
            } catch (Exception e) {
                Log.d(LOG_ASYNC,e.getMessage());
            }
            return output;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d(LOG_ASYNC,"Status : onPostExecute");

            AsyncCallBack mListener = this.mListener.get();
            if (mListener != null){
                mListener.onPostExecute(result);
            }
        }
    }
}
