package com.hh1995.myinsta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FragmentHome extends Fragment {

    RecyclerView cirRecycler;
    RecyclerView mainRecycler;

    ArrayList<CircleItem> circleItems=new ArrayList<>();
    CircleAdapter circleAdapter;

    ArrayList<HomeItem> homeItems=new ArrayList<>();
    HomeAdapter homeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);

        circleItems.clear();
        circleItems.add(new CircleItem(R.drawable.giraffe,"기린"));
        circleItems.add(new CircleItem(R.drawable.elephant,"코끼리"));
        circleItems.add(new CircleItem(R.drawable.snake,"뱀"));

        cirRecycler=view.findViewById(R.id.recylcer_circle);
        circleAdapter=new CircleAdapter(getContext(),circleItems);
        cirRecycler.setAdapter(circleAdapter);

//        homeItems.clear();
//        homeItems.add(new HomeItem("아이디","5개","안녕하세요",R.drawable.moana02));
//        homeItems.add(new HomeItem("아이디","4개","감사합니다",R.drawable.moana01));
//        homeItems.add(new HomeItem("아이디","3개","고마워요",R.drawable.bg_one10));

        mainRecycler=view.findViewById(R.id.recylcer_main);
        homeAdapter=new HomeAdapter(getContext(),homeItems);
        mainRecycler.setAdapter(homeAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    void loadData(){
        Retrofit retrofit=RetrofitHelper.getInstance();
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);
        Call<ArrayList<HomeItem>> call=retrofitService.loadDataFromHome();
        call.enqueue(new Callback<ArrayList<HomeItem>>() {
            @Override
            public void onResponse(Call<ArrayList<HomeItem>> call, Response<ArrayList<HomeItem>> response) {
                Toast.makeText(getContext(), "성공", Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    ArrayList<HomeItem> items=response.body();
                    homeItems.clear();
                    homeAdapter.notifyDataSetChanged();
                    for (HomeItem item:items){
                        homeItems.add(0,item);
                        homeAdapter.notifyItemInserted(0);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<HomeItem>> call, Throwable t) {
                Toast.makeText(getContext(), t+"", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
