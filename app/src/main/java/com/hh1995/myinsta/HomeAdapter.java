package com.hh1995.myinsta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.internal.$Gson$Preconditions;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        vh.intro.setText(homeItem.msg);

        String imgUri="http://hkh26.dothome.co.kr/Home/"+homeItem.file;
        Glide.with(context).load(imgUri).into(vh.mainImg);
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    class VH extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView intro;

        ImageView idImg;
        ImageView mainImg;

        ImageButton more;
        ToggleButton like;
        ToggleButton chat;
        ToggleButton send;
        ToggleButton book;


        public VH(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.epi_tvid);
            intro=itemView.findViewById(R.id.tvIntro);
            idImg=itemView.findViewById(R.id.epi_img);
            mainImg=itemView.findViewById(R.id.epi_mainImg);
            more=itemView.findViewById(R.id.moreBtn);

            like=itemView.findViewById(R.id.like);
            chat=itemView.findViewById(R.id.chat);
            send=itemView.findViewById(R.id.send);

            book=itemView.findViewById(R.id.book);

            chat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "chat", Toast.LENGTH_SHORT).show();
                }
            });

            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "send", Toast.LENGTH_SHORT).show();
                }
            });

            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "book", Toast.LENGTH_SHORT).show();
                }
            });



            like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    //바꿔야 할 데이터는 'favor'뿐이지만 나중에 확장성을 위해
                    //현재 누른 아이템 항목 얻어오기
                    HomeItem item=homeItems.get(getLayoutPosition());
                    item.like=isChecked?1:0;

                    RetrofitService retrofitService=RetrofitHelper.getInstance().create(RetrofitService.class);
                    Call<HomeItem> call=retrofitService.updateData("updateFavor.php",item);
                    call.enqueue(new Callback<HomeItem>() {
                        @Override
                        public void onResponse(Call<HomeItem> call, Response<HomeItem> response) {
                        }

                        @Override
                        public void onFailure(Call<HomeItem> call, Throwable t) {

                        }
                    });

                }
            });
        }
    }

}
