package com.example.nasafinal_api;

import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;



public class Techport_Activity extends AppCompatActivity implements TechportDetails_Req.TechportDetails_ReqListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techport_);

        Intent intent=getIntent();
        Bundle bundle = intent.getExtras();
        getSupportActionBar().setTitle("Techport Id Details");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nasaBlue)));
        String post=bundle.getString("idbundle");
        TechportDetails_Req req=new TechportDetails_Req(this,post);
        req.execute();
    }

    @Override
    public void techportDetails_ReqDone(String result) {

        try {
            Intent intent=getIntent();
            Bundle bundle = intent.getExtras();

            String post=bundle.getString("idbundle");
            Log.d("idbundle",""+post);
            TextView text=findViewById(R.id.text_id);
            text.setText(post);

            JSONObject jsonObject=new JSONObject(result);
            String project=jsonObject.getString("project");
            JSONObject jsonTitle=new JSONObject(project);
            JSONObject jsonStatus=new JSONObject(project);
            JSONObject jsonStartDate=new JSONObject(project);
            JSONObject jsonEndDate=new JSONObject(project);
            JSONObject jsonDescription=new JSONObject(project);

            String title=jsonTitle.getString("title");
            String status=jsonStatus.getString("status");
            String startDate=jsonStartDate.getString("startDate");
            String endDate=jsonEndDate.getString("endDate");
            String description=jsonDescription.getString("description");

            Log.d("testtitlebaslik",title);

            TextView txt_title=findViewById(R.id.text_title);
            TextView txt_status=findViewById(R.id.text_status);
            TextView txt_startDate=findViewById(R.id.text_startDate);
            TextView txt_endDate=findViewById(R.id.text_endDate);
            TextView txt_description=findViewById(R.id.text_description);

            txt_title.setText(title);
            txt_status.setText(status);
            txt_startDate.setText(startDate);
            txt_endDate.setText(endDate);
            txt_description.setText(description);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
