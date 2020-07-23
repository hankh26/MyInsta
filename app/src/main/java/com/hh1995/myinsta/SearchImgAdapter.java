package com.hh1995.myinsta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchImgAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<SearchImgItem> items;

    public SearchImgAdapter() {
    }

    public SearchImgAdapter(Context context, ArrayList<SearchImgItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.img_menu,parent,false);
        VH holder= new VH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        SearchImgItem imgItem=items.get(position);
        vh.iv.setImageResource(imgItem.file);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView iv;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.search_img);
        }
    }
}
