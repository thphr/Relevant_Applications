package com.example.bruger.pictureexplore;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Bruger on 22-08-2018.
 */

public class JsonHandler {

    String responseResult = "";



    public ArrayList parseToJson(String rawData) {

        String jsonStringResult = "";
        ArrayList<Photo> photoList = new ArrayList<>(10);

        try{

            JSONObject jsonObj = new JSONObject(rawData);

            JSONObject jsonPhotos = jsonObj.getJSONObject("photos");

            JSONArray jsonArrayPhoto = jsonPhotos.getJSONArray("photo");


            for(int i = 0; i < jsonArrayPhoto.length(); i++) {

                JSONObject photoFlickr = jsonArrayPhoto.getJSONObject(i);

                String ID = photoFlickr.getString("id");
                String owner = photoFlickr.getString("owner");
                String secret = photoFlickr.getString("secret");
                String server = photoFlickr.getString("server");
                String farm = photoFlickr.getString("farm");
                String title = photoFlickr.getString("title");

                Photo photo = new Photo(ID,owner,secret,farm,server,title);

                photoList.add(photo);
             }

                /**
                jsonStringResult = "ID: " + photoFlickr.getString("id") + "\n" +
                        "Owner: " + photoFlickr.getString("owner") + "\n" +
                        "Secret: " + photoFlickr.getString("secret") + "\n" +
                        "Sever: " + photoFlickr.getString("server") + "\n" +
                        "Farm:  " + photoFlickr.getString("farm") + "\n" +
                        "Title: "  + photoFlickr.getString("title");
                 */



        }catch (JSONException e) {
            e.printStackTrace();
            System.out.println("FALIED");
        }

        return photoList;
    }

}
