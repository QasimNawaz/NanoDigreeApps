package com.example.android.miwok.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.AdapterAndModules.Word;
import com.example.android.miwok.AdapterAndModules.WordAdapter;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

       getSupportFragmentManager().beginTransaction().replace(R.id.container,new PhrasesFragment()).commit();





    }
}
