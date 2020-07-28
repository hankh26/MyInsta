package com.hh1995.myinsta;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
        Glide.with(context).load(imgItem.file).into(vh.iv);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView iv;
        ImageView ivv;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.search_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    SearchImgItem item=items.get(getLayoutPosition());

                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
                    LayoutInflater inflater=LayoutInflater.from(context);
                    View view=inflater.inflate(R.layout.img_menu,null);
                    ivv=view.findViewById(R.id.search_img);
                    ivv.setImageResource(item.file);
                    builder.setView(view);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                }
            });

        }
    }
}
