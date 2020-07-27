package com.hh1995.myinsta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;

    Fragment[] fragments=new Fragment[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        fragments[0]=new FragmentHome();
        fragments[1]=new FragmentSearch();
        fragments[2]=new FragmentAdd();
        fragments[3]=new FragmentLike();
        fragments[4]=new FragmentMyInfo();

        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.fragment,fragments[0]);
        transaction.commit();

        bottomNavigationView=findViewById(R.id.bottmNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction1=fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.menu_home:
                        transaction1.replace(R.id.fragment,fragments[0]);
                        break;
                    case R.id.menu_search:
                        transaction1.replace(R.id.fragment,fragments[1]);
                        break;
                    case R.id.menu_add:
                        transaction1.replace(R.id.fragment,fragments[2]);
                        break;
                    case R.id.menu_like:
                        transaction1.replace(R.id.fragment,fragments[3]);
                        break;
                    case R.id.menu_myInfo:
                        transaction1.replace(R.id.fragment,fragments[4]);
                        break;
                }
                transaction1.commit();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option_send:
                
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
