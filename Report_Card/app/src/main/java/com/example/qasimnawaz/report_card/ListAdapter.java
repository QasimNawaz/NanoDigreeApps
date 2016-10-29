package com.example.qasimnawaz.report_card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Qasim Nawaz on 9/28/2016.
 */

public class ListAdapter extends ArrayAdapter<Report> {

    public ListAdapter(Context context, ArrayList<Report> arrayList){
        super(context, R.layout.dataview,arrayList);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.dataview, null);

        Report card = getItem(position);

        ImageView imageView = (ImageView) view.findViewById(R.id.img_card);
        TextView txtName = (TextView) view.findViewById(R.id.txt_name);
        TextView txtGrade = (TextView) view.findViewById(R.id.txt_grade);
        TextView txtPosition = (TextView) view.findViewById(R.id.txt_position);
        TextView txtClassAttend = (TextView) view.findViewById(R.id.txt_classAttend);


        assert card != null;
        txtName.setText(card.getName());
        txtGrade.setText(String.valueOf(card.getGrade()));
        txtPosition.setText(String.valueOf(card.getPosition()));
        txtClassAttend.setText(String.valueOf(card.getClassAttend()));


        return view;

    }

}
