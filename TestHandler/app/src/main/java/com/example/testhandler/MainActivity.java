    package com.example.testhandler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textHandler = findViewById(R.id.idHandler);
    }

    private Handler handler = new Handler(){
        public void handleMessage (Message msg){
            String message = (String) msg.obj;
            textHandler.setText(message);
        }
        };
        @Override
        public void onClick(View v) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final String txt = "JANCUK";
                    Message msg = Message.obtain();
                    msg.obj = txt;
                    msg.setTarget(handler);
                    msg.sendToTarget();
                }
            }).start();
        }
    }
