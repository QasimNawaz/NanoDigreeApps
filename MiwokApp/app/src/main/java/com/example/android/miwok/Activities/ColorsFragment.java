package com.example.android.miwok.Activities;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.AdapterAndModules.Word;
import com.example.android.miwok.AdapterAndModules.WordAdapter;
import com.example.android.miwok.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {


    private Word words;
    private WordAdapter mWordAdapter;
    private ListView mListView;
    private MediaPlayer mMediaPlayer;


    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.word_list, container, false);

        mListView = (ListView) rootview.findViewById(R.id.rootView);

       final ArrayList<Word> mWordArrayList = new ArrayList<>();
        mWordArrayList.add(new Word("White", "blanc", R.drawable.color_white, R.raw.white));
        mWordArrayList.add(new Word("Black", "noir", R.drawable.color_black, R.raw.black));
        mWordArrayList.add(new Word("Red", "rouge", R.drawable.color_red, R.raw.red));
        mWordArrayList.add(new Word("Green", "vert", R.drawable.color_green, R.raw.green));
        mWordArrayList.add(new Word("Yellow", "jaune", R.drawable.color_mustard_yellow, R.raw.yellow));
        mWordArrayList.add(new Word("Dusty Yellow", "poussiéreux jaune", R.drawable.color_dusty_yellow, R.raw.dusty_tellow));
        mWordArrayList.add(new Word("Brown", "marron", R.drawable.color_brown, R.raw.brown));

        mWordAdapter = new WordAdapter(getActivity(), mWordArrayList, R.color.category_colors);
        mListView.setAdapter(mWordAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = mWordArrayList.get(position);
                String s = word.getDefaultTranslation().toString();

                Toast.makeText(getActivity(), "YOu CLick " + s, Toast.LENGTH_SHORT).show();

                mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceID());
                mMediaPlayer.start();
            }
        });

        return rootview;

    }


}
