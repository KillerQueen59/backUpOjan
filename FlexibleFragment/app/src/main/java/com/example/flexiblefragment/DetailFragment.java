package com.example.flexiblefragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener {
    TextView Lifestyle,InfoLifestyle ;
    public static  String EXTRA_NAME = "extra_name";
    public static String EXTRA_DESC = "extra_desc";
    Button btnprofile,tampildialog;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;



    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Lifestyle = view.findViewById(R.id.lifestyle);
        InfoLifestyle = view.findViewById(R.id.infolifestyle);
        btnprofile = view.findViewById(R.id.btnprofile);
        tampildialog = view.findViewById(R.id.tampildialog);
        btnprofile.setOnClickListener(this);
        tampildialog.setOnClickListener(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String categoryName = getArguments().getString(EXTRA_NAME);
        Lifestyle.setText(categoryName);
        InfoLifestyle.setText(getDescription());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(EXTRA_DESC,getDescription());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnprofile:
                Intent intent = new Intent(getActivity(),ProfileActivity.class); //getActivity() karena di dalam fragment
                startActivity(intent);
                break;
            case R.id.tampildialog:

                DialogFrags dialogFrags = new DialogFrags();

                FragmentManager fragmentManager = getChildFragmentManager(); //untuk nested fragment
                dialogFrags.show(fragmentManager,DialogFrags.class.getSimpleName());// getSimple() untuk mengambil informasi dalam kelas
                // menampilkan objek dialogfrags ke layar
                break;

        }
    }

    DialogFrags.OnOptionDialogListener optionDialogListener = new DialogFrags.OnOptionDialogListener() {
    @Override
    public void onOptionChosen(String text) {
        Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
    }
};

}
