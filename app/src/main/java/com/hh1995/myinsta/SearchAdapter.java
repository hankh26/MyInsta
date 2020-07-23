package com.hh1995.myinsta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class SearchAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<SearchItem> items;

    public SearchAdapter() {
    }

    public SearchAdapter(Context context, ArrayList<SearchItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.search_menu,parent,false);
        VH holder=new VH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH) holder;
        SearchItem item=items.get(position);
        vh.tv.setText(item.menu);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{
        TextView tv;

        public VH(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.card_menu);
        }

    }
}
