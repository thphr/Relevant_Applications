package ActivityController;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.bruger.pictureexplore.LoadImage;
import com.example.bruger.pictureexplore.Photo;
import com.example.bruger.pictureexplore.R;

public class displayPicture extends AppCompatActivity {

    private LoadImage l_Image;

    public displayPicture() {
        l_Image = new LoadImage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_picture);

        Intent intent = getIntent();
        Photo photo = (Photo) intent.getSerializableExtra(PictureDisplayController.PHOTO_TRANSFER);

        ImageView photoImage = (ImageView) findViewById(R.id.imageView3);
        new LoadImage(photoImage).execute(l_Image.urlConverter(photo));
    }
}
