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
public class PhrasesFragment extends Fragment {

    private Word words;
    private ArrayList<Word> mWordArrayList ;
    private WordAdapter mWordAdapter;
    private ListView mListView;
    private MediaPlayer mMediaPlayer;


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.word_list, container, false);

        mListView = (ListView) rootview.findViewById(R.id.rootView);

        final ArrayList<Word> mWordArrayList = new ArrayList<>();
        mWordArrayList.add(new Word("Grab a bit", "prendre une bouchée",R.raw.grab_a_beat));
        mWordArrayList.add(new Word("Take it easy", "Relax",R.raw.take_it_easy));
        mWordArrayList.add(new Word("Go with the flow", "suis le mouvement",R.raw.go_with_the_flow));
        mWordArrayList.add(new Word("Under the weather", "sous le temps",R.raw.under_the_weather));
        mWordArrayList.add(new Word("Don't sweat it", "ne vous inquiétez pas",R.raw.dont_sweat_it));
        mWordArrayList.add(new Word("You can say that again", "Tu peux le répéter",R.raw.you_can_say_that_again));
        mWordArrayList.add(new Word("Broke", "cassé",R.raw.broke));
        mWordArrayList.add(new Word("Beats me", "me bat",R.raw.beats_me));
        mWordArrayList.add(new Word("Keep your cool", "garde ton calme",R.raw.keep_your_cool));
        mWordArrayList.add(new Word("Shotgun", "fusil à pompe",R.raw.shotgun));

        mWordAdapter = new WordAdapter(getActivity(),mWordArrayList,R.color.category_phrases);
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
