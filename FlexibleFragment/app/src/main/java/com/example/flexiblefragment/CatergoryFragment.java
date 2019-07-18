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
public class CatergoryFragment extends Fragment implements View.OnClickListener {


    public CatergoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catergory, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnCat = view.findViewById(R.id.btnfragstyle);
        btnCat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DetailFragment detailFragment = new DetailFragment();

        // ngirim data bisa pake set get , bisa pake bundle 

        Bundle bundle = new Bundle(); //mengirimkan data antar fragment
        bundle.putString(DetailFragment.EXTRA_NAME,"Fauzan Ramadhan");// tinggal dipanggil get set arguments nya

        String description = "Seorang mahasiswa tingkat 2 yang gambling ambil projek";

        detailFragment.setArguments(bundle);
        detailFragment.setDescription(description);


        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.tempat_frame,detailFragment,DetailFragment.class.getSimpleName());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

    }
}
