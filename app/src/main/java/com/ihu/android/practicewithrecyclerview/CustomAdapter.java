package com.ihu.android.practicewithrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ItemViewHolder> {

    private final List<ImageItem> imageItems;
    private final ItemClickListener itemClickListener;

    public CustomAdapter(ItemClickListener listener) {
        itemClickListener = listener;
        imageItems = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ItemViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final ImageItem item = imageItems.get(position);
        loadImage(holder, item);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(item);
            }
        });
        holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }

    public void setData(List<ImageItem> items) {
        imageItems.clear();
        imageItems.addAll(items);
        notifyDataSetChanged();
    }

    private void loadImage(ItemViewHolder holder, ImageItem item) {
        Picasso.with(holder.imageView.getContext()).cancelRequest(holder.imageView);
        Context context = holder.imageView.getContext();
        if (context == null) {
            return;
        }
        int dimension = (int) context.getResources().getDimension(R.dimen.image_size);
        Picasso.with(holder.imageView.getContext()).load(item.getUrl()).resize(dimension, dimension).centerCrop().into(holder.imageView);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_image_imageView);
        }
    }

    public interface ItemClickListener{
        void onItemClick(ImageItem item);
    }
}