package com.example.nasafinal_api;

public class AsteroidReq extends BaseReq{
    public AsteroidReq.AsteroidReqListener listener;

    public interface AsteroidReqListener {
        void asteroidReqDone(String result);
    }

    public AsteroidReq(AsteroidReq.AsteroidReqListener listener) {
        this.listener = listener;
    }

    @Override
    public String getReqUrl() {
        return "https://api.nasa.gov/neo/rest/v1/feed?start_date=2020-06-01&api_key=SO41aAenln5kAUVqfzZGiCzVHcxa2tysfZ2uYD5d";
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.asteroidReqDone(result);
    }
}
