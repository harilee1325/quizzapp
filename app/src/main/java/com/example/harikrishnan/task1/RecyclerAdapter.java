package com.example.harikrishnan.task1;

import android.content.Context;
import android.nfc.cardemulation.CardEmulation;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private ArrayList<POJOClass> allFilesSet = new ArrayList<>();

    private Context context;



    public RecyclerAdapter(ArrayList<POJOClass> allFilesSet) {


    }

    public RecyclerAdapter(ArrayList<POJOClass> allFilesSet, Context context) {
        this.allFilesSet = allFilesSet;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG,"binderviewholder");
        TextView textView = viewHolder.catName;
        ImageView imageView = viewHolder.catImage;

        textView.setText(allFilesSet.get(i).getName());
        imageView.setImageResource(allFilesSet.get(i).getImage());

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"clicked");
                Toast.makeText(context,allFilesSet.get(i).getName(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return allFilesSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView catImage;
        TextView catName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.mainCard);
            catImage = itemView.findViewById(R.id.cat_img);
            catName = itemView.findViewById(R.id.cat_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }

}
