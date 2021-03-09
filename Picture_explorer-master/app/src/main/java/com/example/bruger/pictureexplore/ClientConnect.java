package com.example.bruger.pictureexplore;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Bruger on 21-08-2018.
 */

public class ClientConnect {
    //https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=57f57e014d43c73972e4880901e92e34&text=flower&format=json&nojsoncallback=1

    private static AsyncHttpClient client = new AsyncHttpClient();


    public static final String API_KEY = "4dc4a22a77a7b417ea582c6b769c0991";

    private String searchWord = "flower";

    private static final String BASE_URL = "https://api.flickr.com/services/rest/" +
            "?method=flickr.photos.search" +
            "&api_key=4dc4a22a77a7b417ea582c6b769c0991" +
            "&text=flower" +
            "&format=json" +
            "&nojsoncallback=1";

    public static final String URL_TEST = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=57f57e014d43c73972e4880901e92e34&text=flower&format=json&nojsoncallback=1";


    public void get(String url, AsyncHttpResponseHandler responseHandler) {
        client.get(url,responseHandler);

    }

    public void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);
    }

    //private static String getAbsoluteUrl(String relativeUrl) {
    //    return getBaseUrl() + relativeUrl;
    //}

    public String getBaseUrl() {
        return BASE_URL;
    }

}


