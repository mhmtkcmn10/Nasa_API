package com.example.nasafinal_api;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

public class HomeExp_Fragment extends Fragment implements HomeReq.HomeReqListener{
    TextView txt_explation;
    TextView txt_title2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_exphome, container, false);

        txt_explation=root.findViewById(R.id.txt_explation);
        txt_title2=root.findViewById(R.id.txt_title2);

        HomeReq req=new HomeReq(this);
        req.execute();

        return root;
    }

    @Override
    public void homeReqDone(String result) {

        Gson gson = new Gson();
        HomeModel model = gson.fromJson(result, HomeModel.class);
        txt_explation.setText(model.explanation);
        txt_title2.setText(model.title);
    }
}