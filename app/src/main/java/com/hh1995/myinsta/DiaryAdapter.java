package com.hh1995.myinsta;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DiaryAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<DiaryItem> items;

    public DiaryAdapter() {
    }

    public DiaryAdapter(Context context, ArrayList<DiaryItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.day_list,parent,false);
        VH holder=new VH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH) holder;
        DiaryItem diaryItem=items.get(position);
        vh.date.setText(diaryItem.date);
        vh.title.setText(diaryItem.title);
        vh.impressive.setText(diaryItem.impressive);

        String imgUri="http://hkh26.dothome.co.kr/Diary"+diaryItem.file;
        Glide.with(context).load(imgUri).into(vh.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView date;
        TextView title;
        TextView impressive;
        ImageView imageView;

        public VH(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date);
            title=itemView.findViewById(R.id.title);
            impressive=itemView.findViewById(R.id.impressive);
            imageView=itemView.findViewById(R.id.ivinfo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DiaryItem item=items.get(getLayoutPosition());
                    Intent intent=new Intent(context,DetailActivity.class);
                    intent.putExtra("Title",item.title);
                    intent.putExtra("Date",item.date);
                    intent.putExtra("Msg",item.msg);
                    context.startActivity(intent);
                }
            });

        }
    }
}
