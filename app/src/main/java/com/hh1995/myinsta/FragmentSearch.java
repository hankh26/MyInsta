package com.hh1995.myinsta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentSearch extends Fragment {

    RecyclerView recyclerView;
    ArrayList<SearchItem> searchItems=new ArrayList<>();
    SearchAdapter searchAdapter;

    RecyclerView recyclerView2;
    ArrayList<SearchImgItem> searchImgItems=new ArrayList<>();
    SearchImgAdapter searchImgAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_search,container,false);

        searchItems.add(new SearchItem("IGTV"));
        searchItems.add(new SearchItem("Shop"));
        searchItems.add(new SearchItem("장식"));
        searchItems.add(new SearchItem("여행"));
        searchItems.add(new SearchItem("건축"));
        searchItems.add(new SearchItem("음식"));
        searchItems.add(new SearchItem("예술"));
        searchItems.add(new SearchItem("스타일"));
        searchItems.add(new SearchItem("TV 및 영화"));
        searchItems.add(new SearchItem("DIY"));
        searchItems.add(new SearchItem("음악"));
        searchItems.add(new SearchItem("스포츠"));
        searchItems.add(new SearchItem("만화"));
        recyclerView=view.findViewById(R.id.searh_recycler);
        searchAdapter=new SearchAdapter(getContext(),searchItems);
        recyclerView.setAdapter(searchAdapter);

        searchImgItems.add(new SearchImgItem(R.drawable.bg_one01));
        searchImgItems.add(new SearchImgItem(R.drawable.bg_one02));
        searchImgItems.add(new SearchImgItem(R.drawable.bg_one03));
        searchImgItems.add(new SearchImgItem(R.drawable.bg_one04));
        searchImgItems.add(new SearchImgItem(R.drawable.bg_one05));
        searchImgItems.add(new SearchImgItem(R.drawable.bg_one06));
        searchImgItems.add(new SearchImgItem(R.drawable.bg_one07));
        searchImgItems.add(new SearchImgItem(R.drawable.bg_one08));
        searchImgItems.add(new SearchImgItem(R.drawable.bg_one09));
        searchImgItems.add(new SearchImgItem(R.drawable.bg_one10));
        searchImgItems.add(new SearchImgItem(R.drawable.one_3));
        searchImgItems.add(new SearchImgItem(R.drawable.one_ace));
        searchImgItems.add(new SearchImgItem(R.drawable.one_chopa2));
        searchImgItems.add(new SearchImgItem(R.drawable.one_luffy));
        searchImgItems.add(new SearchImgItem(R.drawable.one_nami5));
        searchImgItems.add(new SearchImgItem(R.drawable.one_nicorobin));
        searchImgItems.add(new SearchImgItem(R.drawable.one_sandi));
        recyclerView2=view.findViewById(R.id.search_ImgRecycler);
        searchImgAdapter=new SearchImgAdapter(getContext(),searchImgItems);
        recyclerView2.setAdapter(searchImgAdapter);


        return view;
    }
}
