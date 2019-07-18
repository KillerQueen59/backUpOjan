package com.example.flexiblefragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFrags extends DialogFragment implements View.OnClickListener { //Dialog Fragment untuk menambil dialog pada fragment
    Button btnChoose, btnClose;
    RadioGroup rg_options;
    RadioButton rbSaf, rbMou, LVG, Moyes;
    OnOptionDialogListener optionDialogListener; // interface (optionChose)

    public DialogFrags() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_frags, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnClose = view.findViewById(R.id.close);
        btnChoose = view.findViewById(R.id.pilih);
        rg_options = view.findViewById(R.id.rg_options);
        rbSaf = view.findViewById(R.id.saf);
        rbMou = view.findViewById(R.id.mou);
        LVG = view.findViewById(R.id.lvg);
        Moyes = view.findViewById(R.id.moyes);

        btnChoose.setOnClickListener(this);
        btnClose.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) { //
        super.onAttach(context);

        /*
        Saat attach maka set optionDialogListener dengan listener dari detailCategoryFragment
         */
        Fragment fragment = getParentFragment();

        if(fragment instanceof DetailFragment){
            DetailFragment detailFragment = (DetailFragment)fragment;
            this.optionDialogListener = detailFragment.optionDialogListener; //
        }
    }

    @Override
    public void onDetach() { //
        super.onDetach();
        this.optionDialogListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.close:
                getDialog().cancel(); // cancel fragment dialog
                break;
            case R.id.pilih:
                int checkedRadioButtonId = rg_options.getCheckedRadioButtonId(); // mengecek nilai radio button
                if(checkedRadioButtonId != -1){ //
                    String coach = null;
                    switch (checkedRadioButtonId){
                        case R.id.saf:
                            coach = rbSaf.getText().toString().trim();
                            break;
                        case R.id.mou:
                            coach = rbMou.getText().toString().trim();
                            break;
                        case R.id.lvg:
                            coach = LVG.getText().toString().trim();
                            break;
                        case R.id.moyes:
                            coach = Moyes.getText().toString().trim();
                            break;
                    }
                    if (optionDialogListener != null){
                        optionDialogListener.onOptionChosen(coach); // ngebuat optiondialog milih coach dari optionchosen
                    }
                    getDialog().dismiss();// finish the fragmentdialog
                }
                break;

        }

    }

    public interface OnOptionDialogListener {
        void onOptionChosen(String text); // Interface adalah sebuah kelas yang terdiri kumpulan method yang hanya memuat deklarasi dan struktur method, tanpa detail implementasinya.
    }

}

