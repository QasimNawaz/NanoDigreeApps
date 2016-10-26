package com.example.qasimnawaz.newsapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.qasimnawaz.newsapp.R;

import java.util.ArrayList;

/**
 * Created by Qasim Nawaz on 10/25/2016.
 */

public class ListAdapter extends ArrayAdapter<WordAdapter> {
    public ListAdapter(Context context, ArrayList<WordAdapter> news) {
        super(context,0, news);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WordAdapter currentNews = getItem(position);
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items,parent,false);

        }

        TextView title = (TextView) convertView.findViewById(R.id.newstitle_textview);
        title.setText(currentNews.getMtitle());
        return convertView;
    }
}
