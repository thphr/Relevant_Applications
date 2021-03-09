package ActivityController;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruger.pictureexplore.Authentication;
import com.example.bruger.pictureexplore.Authentication2;
import com.example.bruger.pictureexplore.R;

import java.util.concurrent.ExecutionException;


public class login extends AppCompatActivity {

    Authentication authentication;
    Authentication2 authentication2;
    Button button;
    TextView textView;

    public login() {
        authentication = new Authentication();
        authentication2 = new Authentication2();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**
        button = (Button) findViewById(R.id.button_login);
        textView = (TextView) findViewById(R.id.textView_Login);
        textView.setText("Click to login to flickr !");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });*/


        String url = "";
        try {
            url = authentication.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }




        Uri uri = Uri.parse(url);
        Intent intenBrowser = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intenBrowser);




        Uri uri1 = getIntent().getData();
        if (uri1 != null && uri1.toString().startsWith("oauth://com.example.bruger.pictureexplore")) {
            String verifier = uri1.getQueryParameter("oauth_verifier");
            String oauth_token = uri.getQueryParameter("oauth_token");

            String user = "";
            try {
                user = authentication2.execute(oauth_token, authentication.getToken().getOauthTokenSecret(),verifier).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(login.this, My_Profile.class);
            intent.putExtra("User",user);
            startActivity(intent);
        }





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
