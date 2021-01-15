package com.example.todotask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


import com.example.todotask.mydataBase.EntityClass;
import com.example.todotask.mydataBase.MainViewModelClass;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton add;
    RecyclerView list;
    ArrayList<EntityClass> arr;
    RecyclerView.LayoutManager manager;
    MainViewModelClass model ;
    MyAdapter adapter;


    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        arr = new ArrayList<EntityClass>();
        adapter= new MyAdapter(this);
        setFab();
        setViewModel();
        setRecycler();

    }



    public void setFab() {

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewNote.class);
                startActivity(intent);
            }
        });
    }

    public  void initViews () {
       // manager = new LinearLayoutManager(this);
        add = (FloatingActionButton) (findViewById(R.id.add_btn));
        list = (RecyclerView) (findViewById(R.id.my_list));
    }

    public void setRecycler(){
        manager = new LinearLayoutManager(this);
        list.setLayoutManager(manager);
        list.setHasFixedSize(true);
        list.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public void setViewModel(){

      model = new ViewModelProvider(MainActivity.this).get(MainViewModelClass.class);
      model.getAll().observe(this, new Observer<List<EntityClass>>() {
          @Override
          public void onChanged(List<EntityClass> entityClasses) {

              adapter.setNotes(arr);


          }
      });

}

}


