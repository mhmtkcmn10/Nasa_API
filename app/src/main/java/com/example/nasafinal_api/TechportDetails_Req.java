package com.example.nasafinal_api;

public class TechportDetails_Req extends BaseReq{

    public TechportDetails_Req.TechportDetails_ReqListener listener;

    public interface TechportDetails_ReqListener {
        void techportDetails_ReqDone(String result);
    }
    String id;
    public TechportDetails_Req(TechportDetails_Req.TechportDetails_ReqListener listener,String id) {
        this.listener = listener;
        this.id=id;
    }

    @Override
    public String getReqUrl() {
        return "https://api.nasa.gov/techport/api/projects/"+id+"?api_key=SO41aAenln5kAUVqfzZGiCzVHcxa2tysfZ2uYD5d";
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.techportDetails_ReqDone(result);
    }
}