package ActivityController;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bruger.pictureexplore.R;

public class My_Profile extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__profile);

        Intent intent = getIntent();
        String user = intent.getStringExtra("User");

        textView = (TextView) findViewById(R.id.textView_profile);

        textView.setText(user);


    }
}
