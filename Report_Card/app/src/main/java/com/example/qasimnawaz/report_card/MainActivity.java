package com.example.qasimnawaz.report_card;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Report> arrayList = new ArrayList<>();
        arrayList.add(new Report("Affraz",R.drawable.affraz,"A+",1,"Present"));
        arrayList.add(new Report("Emmad",R.drawable.emmad,"B",2,"Present"));
        arrayList.add(new Report("Ghassan",R.drawable.ghassan,"A",3,"Present"));
        arrayList.add(new Report("Haris",R.drawable.haris,"B+",4,"Absent"));
        arrayList.add(new Report("Imran",R.drawable.imran,"C+",5,"Absent"));
        arrayList.add(new Report("Umer",R.drawable.umer,"D",6,"Present"));
        arrayList.add(new Report("Zafar",R.drawable.zafar,"C",7,"Absent"));
        arrayList.add(new Report("Arsalan",R.drawable.arsalan,"A",8,"Present"));
        arrayList.add(new Report("Bilal",R.drawable.bilal,"A+",9,"Present"));

        ListView listView = (ListView)findViewById(R.id.list);
        ListAdapter adapter = new ListAdapter(MainActivity.this,arrayList);
        listView.setAdapter(adapter);
    }
}
