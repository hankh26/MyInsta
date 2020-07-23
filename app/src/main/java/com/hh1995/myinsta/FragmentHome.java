package com.hh1995.myinsta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
        circleItems.add(new CircleItem(R.drawable.giraffe,"기린"));
        circleItems.add(new CircleItem(R.drawable.elephant,"코끼리"));
        circleItems.add(new CircleItem(R.drawable.snake,"뱀"));

        cirRecycler=view.findViewById(R.id.recylcer_circle);
        circleAdapter=new CircleAdapter(getContext(),circleItems);
        cirRecycler.setAdapter(circleAdapter);

        homeItems.add(new HomeItem("아이디","5개","안녕하세요"));
        homeItems.add(new HomeItem("아이디","4개","감사합니다"));
        homeItems.add(new HomeItem("아이디","3개","고마워요"));

        mainRecycler=view.findViewById(R.id.recylcer_main);
        homeAdapter=new HomeAdapter(getContext(),homeItems);
        mainRecycler.setAdapter(homeAdapter);

        return view;
    }
}
