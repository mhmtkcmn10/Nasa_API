package com.example.nasafinal_api;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;

public class Home_Fragment extends Fragment implements HomeReq.HomeReqListener  {
    TextView txt_title;
    ImageView image;
    String url_image;
    //private DrawerLayout drawer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_home, container, false);
        //drawer = root.findViewById(R.id.drawer_layout);
        txt_title=root.findViewById(R.id.txt_title);
        image=root.findViewById(R.id.imageReq);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new HomeExp_Fragment());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        txt_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new HomeExp_Fragment());
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });
        HomeReq req=new HomeReq(this);
        req.execute();
        return root;
    }

    @Override
    public void homeReqDone(String result) {
        Gson gson = new Gson();
        HomeModel model = gson.fromJson(result, HomeModel.class);
        txt_title.setText(model.title);

        ImageRequest imageReq=new ImageRequest(image);
        url_image=model.url;
        imageReq.execute(url_image);
    }
}
