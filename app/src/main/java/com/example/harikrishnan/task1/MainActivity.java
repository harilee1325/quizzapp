package com.example.harikrishnan.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static  RecyclerView recyclerView;
    private static ArrayList<POJOClass> allFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.categoryList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        allFiles = new ArrayList<POJOClass>();

        for (int i=0; i<Resources.name.length; i++){

            allFiles.add(new POJOClass(Resources.name[i],Resources.images[i]));

        }
        adapter  = new RecyclerAdapter(allFiles);
        recyclerView.setAdapter(adapter);


    }


}
