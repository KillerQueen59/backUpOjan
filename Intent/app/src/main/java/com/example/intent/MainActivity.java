package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button MoveAct,MoveData,MoveObject,DialUp,MoveResult;
    TextView hasilresult;

    private int REQUEST_CODE = 100; //



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MoveAct = findViewById(R.id.moveactivity);
        MoveData = findViewById(R.id.movedata);
        MoveObject = findViewById(R.id.moveobject);
        DialUp = findViewById(R.id.dialbutton);
        MoveResult = findViewById(R.id.moveresult);
        hasilresult = findViewById(R.id.hasilresult);


        MoveObject.setOnClickListener(this); // this menandakan intennya untuk activity ini
        MoveAct.setOnClickListener(this);
        MoveData.setOnClickListener(this);
        DialUp.setOnClickListener(this);
        MoveResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.moveactivity:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.movedata:
                Intent intent1 = new Intent(MainActivity.this,MainData.class);
                intent1.putExtra(MainData.EXTRA_NAME,"Fauzan Ramadhan");
                intent1.putExtra(MainData.EXTRA_AGE,19);
                startActivity(intent1);
                break;
            case R.id.moveobject:
                Person person = new Person();// menciptakan objek person
                // jadi gausah pake put extra di intent, put extranya tinggal ke personnya aja
                person.setName("Fauzan Ramadhan");
                person.setAge(19);
                person.setEmail("Fauzanramadhan59@gmail.com");
                person.setCity("Bogor");

                Intent intent3 = new Intent(MainActivity.this,MainObject.class);
                intent3.putExtra(MainObject.EXTRA_PERSON,person);
                startActivity(intent3);
                break;
            case R.id.dialbutton:
                String phonenumber = "082124721419";
                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phonenumber));
                // Action pada intent beragam
                //Uri = sebuah untaian karakter yang digunakan untuk mengidentifikasi nama, sumber, atau layanan di internet sesuai dengan RFC 2396
                // di uri ga cuman tel: doang. ada banyak.
                startActivity(intent2);
                break;
            case R.id.moveresult:
                Intent intent4 = new Intent(MainActivity.this,MainResult.class);
                startActivityForResult(intent4,REQUEST_CODE); //
                break;

        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == MainResult.RESULT_CODE);
            int dataterpilih = data.getIntExtra(MainResult.EXTRA_SELECTED_VALUE,0);
            hasilresult.setText(String.format("Umur Ojan : %s",dataterpilih));

        }
    }
}
