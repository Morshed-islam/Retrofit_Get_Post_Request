package com.techmorshed.simplegetrequest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.techmorshed.simplegetrequest.R;
import com.techmorshed.simplegetrequest.model.Network;

import java.util.List;

public class MyListAdapter extends BaseAdapter {

    List<Network.Image> list;
    Context context;

    public MyListAdapter(Context context,List<Network.Image> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null){

            View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);

            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String url = "http://www.bing.com/" + list.get(position).getUrl();
        String title = list.get(position).getStartdate();


        Glide.with(context).load(url).into(viewHolder.imageView);
        viewHolder.title.setText(title);


        return viewHolder.itemView;
    }

    public static class ViewHolder{

        ImageView imageView;
        View itemView;
        TextView title;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
            imageView = itemView.findViewById(R.id.retrofit_img_listView);
            title = itemView.findViewById(R.id.title_tv);
        }

    }
}