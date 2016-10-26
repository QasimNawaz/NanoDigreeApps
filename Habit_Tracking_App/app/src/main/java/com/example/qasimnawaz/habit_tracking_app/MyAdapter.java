package com.example.qasimnawaz.habit_tracking_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Qasim Nawaz on 10/26/2016.
 */

public class MyAdapter extends BaseAdapter implements ListAdapter {

    private List<Habits> arrayList;
    private Context context;

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrayList.get(position).getId();
    }

    public MyAdapter(List<Habits> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.view,null);

        TextView text1= (TextView) view.findViewById(R.id.textView);
        CheckBox checkMon = (CheckBox)view.findViewById(R.id.Monday);
        CheckBox checkTue = (CheckBox)view.findViewById(R.id.Tuesaday);
        CheckBox checkWed = (CheckBox)view.findViewById(R.id.wed);
        CheckBox checkThu = (CheckBox)view.findViewById(R.id.thu);
        CheckBox checkFri = (CheckBox)view.findViewById(R.id.fir);
        CheckBox checkSat = (CheckBox)view.findViewById(R.id.sat);
        CheckBox checkSun = (CheckBox)view.findViewById(R.id.sunday);

        text1.setText(arrayList.get(position).getTitle());
        String s = arrayList.get(position).getDiscription();
        if(s.equals("Monday")){
            checkMon.setChecked(true);
        }
        else if(s.equals("Tuesday")){
            checkTue.setChecked(true);
        }
        else if(s.equals("Wednesday")){
            checkWed.setChecked(true);
        }
        else  if(s.equals("Thursday")){
            checkThu.setChecked(true);
        }
        else  if(s.equals("Friday")){
            checkFri.setChecked(true);
        }
        else   if(s.equals("Saturday")){
            checkSat.setChecked(true);
        }
        else  if(s.equals("Sunday")){
            checkSun.setChecked(true);
        }

        return view;
    }
}
