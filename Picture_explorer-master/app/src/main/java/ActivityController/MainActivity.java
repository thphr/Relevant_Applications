package ActivityController;

import android.accounts.AuthenticatorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bruger.pictureexplore.Authentication;
import com.example.bruger.pictureexplore.ClientConnect;
import com.example.bruger.pictureexplore.JsonHandler;
import com.example.bruger.pictureexplore.LoadImage;
import com.example.bruger.pictureexplore.MapsActivity;
import com.example.bruger.pictureexplore.R;
import com.googlecode.flickrjandroid.FlickrException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    Button button;
    Button button2;
    Button button3;
    Context mContext;
    ClientConnect cli = new ClientConnect();
    JsonHandler jH = new JsonHandler();
    String Base_PHOTO_URL = "https://farm%s.staticflickr.com/%s/%s_%s_n.jpg";
    String farm = "2";
    String server = "1841";
    String ID = "44191352071";
    String secret = "6dc26c51fa";
    String TEST_URL = String.format(Base_PHOTO_URL,farm,server,ID,secret);


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, PictureDisplayController.class);
                startActivity(intent);
            }
        });



        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent2);
            }
        });


        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 =new Intent(MainActivity.this, login.class);
                startActivity(intent3);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
