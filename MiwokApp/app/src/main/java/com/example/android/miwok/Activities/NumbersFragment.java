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
public class NumbersFragment extends Fragment {

    private Word words;
    private WordAdapter mWordAdapter;
    private ListView mListView;
    private MediaPlayer mMediaPlayer;


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.word_list,container,false);

        mListView = (ListView) rootview.findViewById(R.id.rootView);

        final ArrayList<Word> mWordArrayList = new ArrayList<>();
        mWordArrayList.add(new Word("One", "un", R.drawable.number_one, R.raw.one));
        mWordArrayList.add(new Word("Two", "deux", R.drawable.number_two, R.raw.two));
        mWordArrayList.add(new Word("Three", "Trois", R.drawable.number_three, R.raw.three));
        mWordArrayList.add(new Word("Four", "quatre", R.drawable.number_four, R.raw.four));
        mWordArrayList.add(new Word("Five", "cinq", R.drawable.number_five, R.raw.five));
        mWordArrayList.add(new Word("Six", "six", R.drawable.number_six, R.raw.six));
        mWordArrayList.add(new Word("Seven", "Sept", R.drawable.number_seven, R.raw.seven));
        mWordArrayList.add(new Word("Eight", "huit", R.drawable.number_eight, R.raw.eight));
        mWordArrayList.add(new Word("Nine", "neuf", R.drawable.number_nine, R.raw.nine));
        mWordArrayList.add(new Word("Ten", "Dix", R.drawable.number_ten, R.raw.ten));

        mWordAdapter = new WordAdapter(getActivity(),mWordArrayList, R.color.category_numbers);
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
