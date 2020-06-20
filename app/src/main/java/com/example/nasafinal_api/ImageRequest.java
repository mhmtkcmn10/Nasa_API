package com.example.nasafinal_api;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

public class ImageRequest extends AsyncTask<String, Void, Bitmap> {
    ImageView resimImage;
    //public ImageRequest.ImageRequestListener listener;

    public ImageRequest(ImageView resimImage) {

        this.resimImage = resimImage;
    }
    protected Bitmap doInBackground(String... strings) {
        String url = strings[0];
        Bitmap bitmap = null;
        try {
            InputStream inputStream = new java.net.URL(url).openStream();

            bitmap = BitmapFactory.decodeStream(inputStream);

        } catch (Exception e) {

            Log.e("Hata :", e.getMessage());

            e.printStackTrace();
        }

        return bitmap;
    }

    protected void onPostExecute(Bitmap result) {
        resimImage.setImageBitmap(result);
    }

}
