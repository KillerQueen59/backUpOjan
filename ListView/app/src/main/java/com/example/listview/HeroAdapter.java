package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Hero> herolist;

    public void setHerolist(ArrayList<Hero> herolist) {
        this.herolist = herolist;
    }

    public HeroAdapter(Context context) {
        this.context = context;
        herolist = new ArrayList<>();//
    }

    @Override
    public int getCount() {
        return herolist.size();
    } //untuk mengetahui berapa banyak item yang akan di tampilkan

    @Override
    public Object getItem(int position) {
        return herolist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //untuk memanggil layout item xml yang sudah kita buat
        if (convertView == null){ //Menghubungkan ViewHolder dengan View

            convertView = LayoutInflater.from(context).inflate(R.layout.item_hero,parent,false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);        //Mengubah nilai pahlawan sesuai dari posisinya

        Hero hero = (Hero) getItem(position);
        viewHolder.bind(hero);
        return convertView;
    }

    private class ViewHolder {
        private TextView Nama;
        private TextView Descrip;
        private ImageView PhotoImage;

        public ViewHolder(View convertView) {
            Nama = convertView.findViewById(R.id.namaHero);
            Descrip = convertView.findViewById(R.id.descHero);
            PhotoImage = convertView.findViewById(R.id.photoHero);
        }

        public void bind(Hero hero) {
            Nama.setText(hero.getName());
            Descrip.setText(hero.getDesc());
            PhotoImage.setImageResource(hero.getPhoto());
        }
    }
}
