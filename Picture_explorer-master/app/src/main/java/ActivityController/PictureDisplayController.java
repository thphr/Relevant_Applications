package ActivityController;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.bruger.pictureexplore.ClientConnect;
import com.example.bruger.pictureexplore.JsonHandler;
import com.example.bruger.pictureexplore.Photo;
import com.example.bruger.pictureexplore.PhotoAdapter;
import com.example.bruger.pictureexplore.R;
import com.example.bruger.pictureexplore.RecyclerItemClickListener;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class PictureDisplayController extends AppCompatActivity   {


    JsonHandler jsonHandler = new JsonHandler();
    ClientConnect cli = new ClientConnect();
    Context context = this;
    public static final String PHOTO_TRANSFER = "PHOTO_TRANSFER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_display_controller);

        final RecyclerView recycleView = (RecyclerView) findViewById(R.id.rvContacts);


        cli.get(cli.getBaseUrl(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                try {

                    String responseResult = new String(responseBody);

                    ArrayList<Photo> photo_list = jsonHandler.parseToJson(responseResult);

                    final PhotoAdapter adapter = new PhotoAdapter(photo_list);
                    // Attach the adapter to the recyclerview to populate items

                    recycleView.addItemDecoration(new DividerItemDecoration(getBaseContext(),
                            DividerItemDecoration.VERTICAL));

                    recycleView.setAdapter(adapter);
                    // Set layout manager to position the items
                    recycleView.setLayoutManager(new LinearLayoutManager(context));

                    recycleView.addOnItemTouchListener(
                            new RecyclerItemClickListener(context, recycleView ,new RecyclerItemClickListener.OnItemClickListener() {
                                @Override public void onItemClick(View view, int position) {
                                    // do whatever
                                    Intent intent = new Intent(PictureDisplayController.this, displayPicture.class);
                                    intent.putExtra(PHOTO_TRANSFER, adapter.getPhoto(position));
                                    startActivity(intent);
                                }

                                @Override public void onLongItemClick(View view, int position) {

                                }
                            })
                    );


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }



}
