package com.example.bruger.pictureexplore;


import android.os.AsyncTask;

import com.googlecode.flickrjandroid.Flickr;
import com.googlecode.flickrjandroid.FlickrException;
import com.googlecode.flickrjandroid.REST;
import com.googlecode.flickrjandroid.oauth.OAuth;
import com.googlecode.flickrjandroid.oauth.OAuthToken;
import com.googlecode.flickrjandroid.oauth.OAuthInterface;
import com.googlecode.flickrjandroid.oauth.OAuthUtils;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

public class Authentication2 extends AsyncTask<String, String, String> {

    private static final String API_KEY = "4dc4a22a77a7b417ea582c6b769c0991";
    private static final String API_SECRET = "d71a07d23d4f0f9d";

    public Authentication2() {

    }


    @Override
    protected String doInBackground(String... strings) {

        OAuth oAuth = null;

        try {
            Flickr flickr = new Flickr(API_KEY,API_SECRET, new REST());
            OAuthInterface authInterface = flickr.getOAuthInterface();

            oAuth = authInterface.getAccessToken(strings[0],strings[1],strings[2]);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();
        } catch ( FlickrException e) {
           e.printStackTrace(); }



        return oAuth.getUser().toString();
    }
}
