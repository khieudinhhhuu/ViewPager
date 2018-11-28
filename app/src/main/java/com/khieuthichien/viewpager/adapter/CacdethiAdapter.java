package com.khieuthichien.viewpager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khieuthichien.viewpager.R;
import com.khieuthichien.viewpager.model.Cacdethi;
import com.khieuthichien.viewpager.ui.ScreenSlideActivity;

import java.util.List;

public class CacdethiAdapter extends RecyclerView.Adapter<CacdethiAdapter.CacdethiHolder> {

    List<Cacdethi> cacdethiList;
    Context context;

    public CacdethiAdapter(List<Cacdethi> cacdethiList, Context context) {
        this.cacdethiList = cacdethiList;
        this.context = context;
    }

    @NonNull
    @Override
    public CacdethiAdapter.CacdethiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cacdethi, parent, false);
        return new CacdethiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CacdethiAdapter.CacdethiHolder holder, int position) {
        final Cacdethi cacdethi = cacdethiList.get(position);
        holder.imganhcacdethi.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);
        holder.tvtencacdethi.setText(cacdethi.getTencacdethi());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.tvtencacdethi.getText().toString().equals("Đề 1")){
                    Intent intent = new Intent(context, ScreenSlideActivity.class);
                    context.startActivity(intent);
                }
                if (holder.tvtencacdethi.getText().toString().equals("Đề 2")){
                    Intent intent = new Intent(context, ScreenSlideActivity.class);
                    context.startActivity(intent);
                }
                if (holder.tvtencacdethi.getText().toString().equals("Đề 3")){
                    Intent intent = new Intent(context, ScreenSlideActivity.class);
                    context.startActivity(intent);
                }
                if (holder.tvtencacdethi.getText().toString().equals("Đề 4")){
                    Intent intent = new Intent(context, ScreenSlideActivity.class);
                    context.startActivity(intent);
                }
                if (holder.tvtencacdethi.getText().toString().equals("Đề 5")){
                    Intent intent = new Intent(context, ScreenSlideActivity.class);
                    context.startActivity(intent);
                }
                if (holder.tvtencacdethi.getText().toString().equals("Đề 6")){
                    Intent intent = new Intent(context, ScreenSlideActivity.class);
                    context.startActivity(intent);
                }
                if (holder.tvtencacdethi.getText().toString().equals("Đề 7")){
                    Intent intent = new Intent(context, ScreenSlideActivity.class);
                    context.startActivity(intent);
                }
                if (holder.tvtencacdethi.getText().toString().equals("Đề 8")){
                    Intent intent = new Intent(context, ScreenSlideActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (cacdethiList == null){
            return 0;
        }
        return cacdethiList.size();
    }

    public class CacdethiHolder extends RecyclerView.ViewHolder {

        private CardView cardview;
        private TextView tvtencacdethi;
        private ImageView imganhcacdethi;

        public CacdethiHolder(View itemView) {
            super(itemView);

            cardview = itemView.findViewById(R.id.cardview);
            tvtencacdethi = itemView.findViewById(R.id.tvtencacdethi);
            imganhcacdethi = itemView.findViewById(R.id.imganhcacdethi);
        }

    }
}
