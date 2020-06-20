package com.example.nasafinal_api;


public class TechportReq extends BaseReq{
    public TechportReq.TechportReqListener listener;

    public interface TechportReqListener {
        void techportReqDone(String result);
    }

    public TechportReq(TechportReq.TechportReqListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqUrl() {
        return "https://api.nasa.gov/techport/api/projects?updatedSince=2020-06-01&api_key=SO41aAenln5kAUVqfzZGiCzVHcxa2tysfZ2uYD5d";
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.techportReqDone(result);
    }
}
