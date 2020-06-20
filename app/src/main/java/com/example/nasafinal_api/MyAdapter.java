package com.example.nasafinal_api;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    /*public MyAdapter(TechportModel arr) {

        this.arr = arr;
    }*/
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        final View view=inflater.inflate(R.layout.recycler_item,viewGroup,false);
        final MyViewHolder holder=new MyViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view.setBackgroundColor(ContextCompat.getColor(viewGroup.getContext(), R.color.nasaBlue));

                String idbundle= (String) holder.txt_id.getText();
                Intent intent=new Intent(v.getContext(),Techport_Activity.class);
                Bundle bundle = new Bundle();
                Log.d("idbundle",idbundle);
                bundle.putString("idbundle",""+idbundle);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }
    public   ArrayList<String> ArrayDizi = new ArrayList<String>();

    public MyAdapter(ArrayList<String> arrayDizi) {

        this.ArrayDizi = arrayDizi;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int post) {
        holder.txt_id.setText(ArrayDizi.get(post));
    }

    @Override
    public int getItemCount() {

        return ArrayDizi.size( );
    }
}