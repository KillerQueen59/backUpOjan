package com.example.asynctasktask2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.btnStart);
        progressBar = findViewById(R.id.progressbar);
    }

    public void startProgress(View view) {
        ExampleTask task = new ExampleTask(this);
        task.execute(10);
    }
    public static class  ExampleTask extends AsyncTask<Integer,Integer,String>{
        private WeakReference<MainActivity> weakReference;
        ExampleTask(MainActivity activity){
            weakReference = new WeakReference<>(activity);
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MainActivity activity = weakReference.get();
            if (activity==null || activity.isFinishing()){
                return;
            }
            activity.progressBar.setVisibility(View.VISIBLE);
            activity.buttonStart.setVisibility(View.INVISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0;i<integers[0];i++){
                publishProgress((i*100)/integers[0]);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Finish DUDE";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            MainActivity activity = weakReference.get();
            if (activity==null || activity.isFinishing()){
                return;
            }
            activity.progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            MainActivity activity = weakReference.get();
            if (activity==null || activity.isFinishing()){
                return;
            }
            activity.progressBar.setProgress(0);
            activity.progressBar.setVisibility(View.INVISIBLE);
            activity.buttonStart.setVisibility(View.VISIBLE);
            Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();

        }
    }
}
