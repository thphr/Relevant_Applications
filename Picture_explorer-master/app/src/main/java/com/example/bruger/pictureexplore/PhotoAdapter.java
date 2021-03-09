package com.example.bruger.pictureexplore;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PhotoAdapter extends
        RecyclerView.Adapter<PhotoAdapter.ViewHolder> {


    private List<Photo> photoList;
    private LoadImage l_Image;


    public PhotoAdapter(List<Photo> photoList) {

        this.photoList = photoList;
        l_Image = new LoadImage();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {

        public TextView textView;
        public ImageView imageView;


        public ViewHolder(View itemView) {

            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.contact_name);
            imageView = (ImageView) itemView.findViewById(R.id.imageView2);


        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        View contactView = inflater.inflate(R.layout.item_content, parent, false);


        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PhotoAdapter.ViewHolder viewHolder, int position) {

        Photo photo = this.photoList.get(position);


        // Set item views based on your views and data model
        TextView textView = viewHolder.textView;
        textView.setText("Titel: " + photo.getTitle().toString());
        ImageView imageView = viewHolder.imageView;
        new LoadImage(imageView).execute(l_Image.urlConverter(photo));



    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public Photo getPhoto(int position) {
        return (null != photoList ? photoList.get(position) : null);
    }

}