package com.example.nasafinal_api;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Techport_Fragment extends Fragment implements TechportReq.TechportReqListener {

    TextView txt_Title;
    RecyclerView recyclerView;
    ArrayList<String> ArrayId=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_techport, container, false);
        recyclerView= root.findViewById(R.id.rc);
        txt_Title=root.findViewById(R.id.txt_title);

        TechportReq req=new TechportReq(this);
        req.execute();

        return root;
    }

    /* class TechDetailGosterme implements TechportDetails_Req.TechportDetails_ReqListener{

        public TechDetailGosterme(){
            for(int i=0;i<ArrayId.size();i++) {
                TechportDetails_Req req = new TechportDetails_Req(this);

    */
                /*TechportDetails_Req req = new TechportDetails_Req(this, ArrayId.get(i));
                req.execute();
            }
        }
        @Override
        public void techportDetails_ReqDone(String result) {
            /*try {
                JSONObject jObject2=new JSONObject(project);
                String title=jObject2.getString("title");

                ArrayDizi.add(title);
                MyAdapter adapter = new MyAdapter(DiziEleman);

                    recyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);

                 */

            /*}catch (JSONException e) {
                e.printStackTrace();
            }*/

     /*   }
    }*/

    @Override
    public void techportReqDone(String result) {
        try {
            JSONObject jsonObject=new JSONObject(result);
            String projects;
                    projects=jsonObject.getString("projects");

            JSONObject jsonObject2=new JSONObject(projects);
            JSONArray jProjects;
                    jProjects=jsonObject2.getJSONArray("projects");

            for (int i=0; i<jProjects.length();i++){
                JSONObject forObject=jProjects.getJSONObject(i);
                String techPortID;
                        techPortID=forObject.getString("id");

                Log.d("id",techPortID);
                ArrayId.add(techPortID);
                if(ArrayId.size()%1==0) {
                    MyAdapter adapter = new MyAdapter(ArrayId);

                    recyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);

                }
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
