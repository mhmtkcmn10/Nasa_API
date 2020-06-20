package com.example.nasafinal_api;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {


    public TextView txt_id;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_id = itemView.findViewById(R.id.txt_id);
    }
}

