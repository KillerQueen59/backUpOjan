package com.example.asynctasktest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private static final String TAG = "MainActivity";
    private Handler handler = new Handler();
    private TextView numbers;
    private int num = 0;
    private volatile boolean stopThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        numbers = findViewById(R.id.numbers);

    }

    public void StartThread(View view) {
        stopThread = false;
      ExampleRunnable exampleRunnable = new ExampleRunnable(10);
      new  Thread(exampleRunnable).start();
    }

    public void StopThread(View view) {
        stopThread = true;
    }
    class ExampleThread extends Thread{
        int seconds;

        ExampleThread(int seconds){
            this.seconds = seconds;
        }
        @Override
        public void run() {
            for (int i = 0 ;i<=10;i++){
                Log.d(TAG, "StartThread: "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class ExampleRunnable implements Runnable{
        int seconds;

        ExampleRunnable(int seconds){
            this.seconds = seconds;
        }
        @Override
        public void run() {
            for (int i = 0 ;i<=10;i++){
                if (stopThread)return;
                final int finalI = i;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        num = finalI;
                        numbers.setText(String.valueOf(num));
                        if (num > 10){
                            numbers.setText("BOOM!!");
                        }
                    }
                });

                Log.d(TAG, "StartThread: "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
