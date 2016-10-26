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
public class FamilyFragment extends Fragment {

    private Word words;
    private WordAdapter mWordAdapter;
    private ListView mListView;
    private MediaPlayer mMediaPlayer;


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.word_list,container,false);

        mListView = (ListView) rootview.findViewById(R.id.rootView);

       final ArrayList<Word> mWordArrayList = new ArrayList<>();
        mWordArrayList.add(new Word("Grand-Father","grand-père",R.drawable.family_grandfather, R.raw.grand_father));
        mWordArrayList.add(new Word("Grand-Mother","grand-mère",R.drawable.family_grandmother, R.raw.grand_mother));
        mWordArrayList.add(new Word("Father","père",R.drawable.family_father,R.raw.father));
        mWordArrayList.add(new Word("Mother","père Mère",R.drawable.family_mother,R.raw.mother));
        mWordArrayList.add(new Word("Son","fils",R.drawable.family_son,R.raw.son));
        mWordArrayList.add(new Word("Daughter","fille",R.drawable.family_daughter,R.raw.daughter));
        mWordArrayList.add(new Word("Brother","frère",R.drawable.family_son,R.raw.brother));
        mWordArrayList.add(new Word("Sister","sœur",R.drawable.family_older_sister,R.raw.sister));
        mWordArrayList.add(new Word("Older Brother","Mashar-Ror",R.drawable.family_older_brother,R.raw.grand_son));
        mWordArrayList.add(new Word("Younger Brother","petit fils",R.drawable.family_younger_brother,R.raw.grand_daughter));
        mWordArrayList.add(new Word("Younger Sister","petite fille",R.drawable.family_younger_sister,R.raw.sister));

        mWordAdapter = new WordAdapter(getActivity(),mWordArrayList,R.color.category_family);
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
