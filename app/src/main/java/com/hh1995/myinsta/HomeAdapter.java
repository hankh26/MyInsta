package com.hh1995.myinsta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.internal.$Gson$Preconditions;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<HomeItem> homeItems;

    public HomeAdapter() {
    }

    public HomeAdapter(Context context, ArrayList<HomeItem> homeItems) {
        this.context = context;
        this.homeItems = homeItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.episode_member,parent,false);
        VH holder=new VH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        HomeItem homeItem=homeItems.get(position);
        vh.tvId.setText(homeItem.id);
        vh.numLike.setText(homeItem.numLike);
        vh.intro.setText(homeItem.Intro);

    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    class VH extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView numLike;
        TextView intro;

        ImageView idImg;
        ImageView mainImg;

        ImageButton more;
        ImageView like;
        ImageView chat;
        ImageView send;


        public VH(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.epi_tvid);
            numLike=itemView.findViewById(R.id.numLike);
            intro=itemView.findViewById(R.id.tvIntro);
            idImg=itemView.findViewById(R.id.epi_img);
            mainImg=itemView.findViewById(R.id.epi_mainImg);
            like=itemView.findViewById(R.id.like);
            chat=itemView.findViewById(R.id.chat);
            send=itemView.findViewById(R.id.send);
            more=itemView.findViewById(R.id.moreBtn);
        }
    }

}
