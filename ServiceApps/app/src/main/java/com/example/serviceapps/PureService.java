package com.example.serviceapps;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class PureService extends Service implements DummyAsyncCallback{
    public static final String ORIGIN_SERVICE = "OriginService";
    static final String TAG = PureService.class.getSimpleName();


    private static class DummyAsycn extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
    public PureService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(ORIGIN_SERVICE,"Jalan Boi");
        return START_STICKY;
    }
    @Override
    public void preAsync(){

    }
    @Override
    public void postAsync(){

    }
}
interface DummyAsyncCallback{//
    void preAsync();
    void postAsync();
}


