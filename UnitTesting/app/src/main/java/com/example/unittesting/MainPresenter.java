package com.example.unittesting;

public class MainPresenter {
    private MainView view;

    MainPresenter(MainView view){// mengambil dari view
        this.view = view;
    }
    public double volume(double panjang,double lebar,double tinggi){//memproses
        return  panjang*lebar*tinggi;
    }

    public void calculateVolume(double panjang,double lebar,double tinggi){// menampilkan di model
        double volume = volume(panjang, lebar, tinggi);
        MainModel model = new MainModel(volume);
        view.showVolume(model);
    }
}
