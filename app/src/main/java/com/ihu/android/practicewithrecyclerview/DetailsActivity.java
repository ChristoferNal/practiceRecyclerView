package com.ihu.android.practicewithrecyclerview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 */
public class DetailsActivity extends FragmentActivity {

    public static final String IMAGE_URL = "image_url";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = (ImageView) findViewById(R.id.activity_details_image);
        String url = getIntent().getStringExtra(IMAGE_URL);
        loadImage(imageView, url);
    }

    private void loadImage(ImageView imageView, String url) {
        Picasso.with(this).cancelRequest(imageView);
        int dimension = (int) getResources().getDimension(R.dimen.image_size);
        Picasso.with(imageView.getContext()).load(url).resize(dimension, dimension).centerCrop().into(imageView);
    }

}