package com.example.flexiblefragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);//LayoutInflater yang berfungsi untuk mengubah layout xml ke dalam bentuk obyek viewgroup atau widget melalui pemanggilan metode inflate().
    }//inflate

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {// untuk inisialisasi view, dan juga mengatur actionnya (set listener).
        super.onViewCreated(view, savedInstanceState);
        Button btnCat = view.findViewById(R.id.btnfragmentcat);
        btnCat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            if (v.getId() == R.id.btnfragmentcat){
                FragmentManager fragmentManager = getFragmentManager(); // mastiin objek nya beneran ada apa engga
                if (fragmentManager != null){
                    CatergoryFragment catergoryFragment = new CatergoryFragment();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.tempat_frame,catergoryFragment,CatergoryFragment.class.getSimpleName()); //transaction mirip sama intent
                    fragmentTransaction.addToBackStack(null);// ingin obyek fragment yang saat ini kita ciptakan masuk ke dalam sebuah fragment stack
                    // biar bisa balik ke fragment sebelumnya.
                    fragmentTransaction.commit();

                }
            }
    }
}
