package com.example.bruger.pictureexplore;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by Bruger on 22-08-2018.
 */

public class LoadImage extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public LoadImage(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    public LoadImage() {

    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);

    }

    public String urlConverter(Photo photo) {

        String Base_PHOTO_URL = "https://farm%s.staticflickr.com/%s/%s_%s_n.jpg";
        String farm = photo.getFarmID().toString();
        String server = photo.getServerID().toString();
        String ID = photo.getId().toString();
        String secret = photo.getSecret().toString();
        String TEST_URL = String.format(Base_PHOTO_URL,farm,server,ID,secret);

        return  TEST_URL;
    }
}