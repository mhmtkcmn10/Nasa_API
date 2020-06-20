package com.example.nasafinal_api;
public class HomeReq extends BaseReq {

    public HomeReqListener listener;

    public interface HomeReqListener {
        void homeReqDone(String result);
    }

    public HomeReq(HomeReqListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqUrl() {
        return "https://api.nasa.gov/planetary/apod?api_key=SO41aAenln5kAUVqfzZGiCzVHcxa2tysfZ2uYD5d";
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.homeReqDone(result);
    }
}
