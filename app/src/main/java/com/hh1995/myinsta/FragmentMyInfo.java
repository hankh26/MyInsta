package com.hh1995.myinsta;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FragmentMyInfo extends Fragment {
    FloatingActionButton floatingActionButton;

    RecyclerView recyclerView;
    ArrayList<DiaryItem> diaryItems=new ArrayList<>();
    DiaryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_myinfo,container,false);

        recyclerView=view.findViewById(R.id.recycler);
        adapter=new DiaryAdapter(getContext(),diaryItems);
        recyclerView.setAdapter(adapter);

        floatingActionButton=view.findViewById(R.id.addDiary);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),DiaryActivity.class);
                startActivity(intent);
            }
        });

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
        Call<ArrayList<DiaryItem>> call=retrofitService.loadDataFromDiary();
        call.enqueue(new Callback<ArrayList<DiaryItem>>() {
            @Override
            public void onResponse(Call<ArrayList<DiaryItem>> call, Response<ArrayList<DiaryItem>> response) {
                if (response.isSuccessful()) {
                    ArrayList<DiaryItem> items=response.body();
                    diaryItems.clear();
                    adapter.notifyDataSetChanged();

                    for (DiaryItem item:items){
                        diaryItems.add(0,item);
                        adapter.notifyItemInserted(0);
                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<DiaryItem>> call, Throwable t) {
                Toast.makeText(getContext(), t+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
