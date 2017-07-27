package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.miwok.MediaControl.mCompleteListener;
import static com.example.android.miwok.MediaControl.mMediaPlayer;
import static com.example.android.miwok.MediaControl.releaseMediaPlayer;
import static com.example.android.miwok.MediaControl.mAudioManager;

public class PharasesActivity extends AppCompatActivity {

    private ArrayList<Word> words = new ArrayList<>();

    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Word word = words.get(position);

            releaseMediaPlayer();

            mMediaPlayer = MediaPlayer.create(PharasesActivity.this, word.getAudioID());
            mMediaPlayer.start();

            mMediaPlayer.setOnCompletionListener(mCompleteListener);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        ListView listView = (ListView) findViewById(R.id.list);
        WordAdaptor itemsAdapter = new WordAdaptor(this, words, R.color.category_phrases);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(mItemClickListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }
}
