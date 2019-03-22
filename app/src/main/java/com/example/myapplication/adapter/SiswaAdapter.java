package com.example.myapplication.adapter;

import android.graphics.Color;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.myapplication.Model.DataSiswa;
import com.example.myapplication.R;

import java.util.List;
import java.util.Random;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.CustomViewHolder> {

    List<DataSiswa> semuasiswaItemList;
    Context mContext;

    public String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    public SiswaAdapter(Context context, List<DataSiswa> siswaList){
        this.mContext=context;
        semuasiswaItemList=siswaList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        public final View myView;
        TextView textNama;
        TextView textNis;
        ImageView imgText;

        CustomViewHolder(View itemView){
            super(itemView);
            myView = itemView;
            textNama = myView.findViewById(R.id.tvNama);
            textNis = myView.findViewById(R.id.tvNIS);
            imgText = myView.findViewById(R.id.ivTextDrawable);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View Itemview = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_siswa,viewGroup,false);
        return new CustomViewHolder(Itemview);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int i) {
        final DataSiswa semuasiswaItem=semuasiswaItemList.get(i);
        holder.textNis.setText(semuasiswaItem.getNis());
        holder.textNama.setText(semuasiswaItem.getNamaLengkap());

        String nama = semuasiswaItem.getNamaLengkap();
        String nama_char = nama.substring(0,1);
        TextDrawable drawable = TextDrawable.builder().buildRound(nama_char,getColor());
        holder.imgText.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return semuasiswaItemList.size();
    }

    public int getColor() {
        String color;
        int randomNumber = 0;
        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        randomNumber = randomGenerator.nextInt(mColors.length);
        if(randomNumber > 12){
            randomNumber = 0;
            color = mColors[randomNumber];
            int colorAsInt = Color.parseColor(color);
            return colorAsInt;
        }else{
            color = mColors[randomNumber];
            int colorAsInt = Color.parseColor(color);
            return colorAsInt;
        }
    }
}
