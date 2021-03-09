package com.example.bruger.pictureexplore;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.googlecode.flickrjandroid.Flickr;
import com.googlecode.flickrjandroid.FlickrException;
import com.googlecode.flickrjandroid.REST;
import com.googlecode.flickrjandroid.oauth.OAuthInterface;
import com.googlecode.flickrjandroid.auth.Permission;
import com.googlecode.flickrjandroid.oauth.OAuthToken;


import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

public class Authentication extends AsyncTask<String, String, String> {

    private static final String API_KEY = "4dc4a22a77a7b417ea582c6b769c0991";
    private static final String API_SECRET = "d71a07d23d4f0f9d";
    private OAuthToken token;
    private String URL;
    private OAuthInterface authInterface;
    private Flickr flickr;



    @Override
    protected String doInBackground(String... strings) {


        try {
            flickr = new Flickr(API_KEY,API_SECRET, new REST());
            authInterface = flickr.getOAuthInterface();


            setToken(authInterface.getRequestToken("oauth://com.example.bruger.pictureexplore"));
            System.out.println("Token: " + getToken());



            URL url = authInterface.buildAuthenticationUrl(Permission.READ, getToken());
            this.setURL(url.toString());




        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch ( FlickrException e) {
            e.printStackTrace();
        }

        return getURL().toString();
    }




    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public OAuthToken getToken() {
        return token;
    }

    public void setToken(OAuthToken token) {
        this.token = token;
    }
}
