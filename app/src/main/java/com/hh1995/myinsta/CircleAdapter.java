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

public class CircleAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<CircleItem> circleItems;

    public CircleAdapter() {
    }

    public CircleAdapter(Context context, ArrayList<CircleItem> circleItems) {
        this.context = context;
        this.circleItems = circleItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.circle_member,parent,false);
        VH holder=new VH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        CircleItem circleItem=circleItems.get(position);
        vh.tv.setText(circleItem.id);

        Glide.with(context).load(circleItem.file).into(vh.iv);
    }

    @Override
    public int getItemCount() {
        return circleItems.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tv;

        public VH(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.circleImg);
            tv=itemView.findViewById(R.id.circleId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CircleItem item=circleItems.get(getLayoutPosition());
                    Intent intent=new Intent(context,CircleDetailActivity.class);
                    intent.putExtra("img",item.file);
                    intent.putExtra("id",item.id);
                    context.startActivity(intent);
                }
            });
        }
    }
}
