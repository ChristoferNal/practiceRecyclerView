package com.ihu.android.practicewithrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ActionBarActivity implements CustomAdapter.ItemClickListener {

    private RecyclerView recyclerView;
    private LayoutManager manager;
    private CustomAdapter adapter;
    private List<ImageItem> imageItemList;
    private List<String> urls = Arrays.asList(
            "http://2.bp.blogspot.com/-hDtR-MJY0rQ/UYUpEkKHiNI/AAAAAAAAAM0/_5Duebe0nyQ/s1600/london2.jpg",
            "http://d.ibtimes.co.uk/en/full/1358785/city-london-night.jpg",
            "https://johngodley.files.wordpress.com/2012/06/regent-street-flags.jpg",
            "http://images.forwallpaper.com/files/thumbs/preview/6/64198__hyde-park-lake-london_p.jpg",
            "http://www.newstatesman.com/sites/default/files/styles/fullnode_image/public/blogs_2014/08/2014_34london.jpg?itok=dHjU4vCD",
            "http://bookwithmatt.com/wp-content/uploads/2014/05/London_Bridge.jpg",
            "http://www.standard.co.uk/incoming/article8568145.ece/binary/original/London_skyline_eLib_5247487.jpg",
            "http://upload.wikimedia.org/wikipedia/commons/b/b4/London_Eye_Twilight_April_2006.jpg",
            "http://www.myscosports.co.uk/wp-content/uploads/2013/10/London-Red-Bus-Wallpapers-HD-Widescreen.jpg",
            "http://i.telegraph.co.uk/multimedia/archive/02248/london-at-dawn_2248134k.jpg",
            "http://www.theblaze.com/wp-content/uploads/2011/11/StPauls1.jpg",
            "http://i.dailymail.co.uk/i/pix/2011/02/16/article-1357502-0D382489000005DC-518_634x421.jpg",
            "http://cdn.londonandpartners.com/asset/318c11a4cef1cb77e8c3c7f67754b19d.jpg"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setupRecyclerView();
        imageItemList = new ArrayList<>();
        populateMockData(imageItemList);
        adapter.setData(imageItemList);
    }

    @Override
    public void onItemClick(ImageItem item) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.IMAGE_URL, item.getUrl());
        startActivity(intent);
    }

    private void populateMockData(List<ImageItem> imageItemList) {
        for (int i = 0; i < urls.size(); i++) {
            ImageItem item = new ImageItem();
            item.setUrl(urls.get(i));
            imageItemList.add(item);
        }
    }

    private void setupRecyclerView() {
        manager = new LinearLayoutManager(this);
        adapter = new CustomAdapter(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

}