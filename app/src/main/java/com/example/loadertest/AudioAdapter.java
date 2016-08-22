package com.example.loadertest;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/12.
 */
public class AudioAdapter extends CursorAdapter {


    public AudioAdapter(Context context) {
        super(context, null,true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_local_video,null);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtAudioName = (TextView) view.findViewById(R.id.txt_VideoName);
        String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
        txtAudioName.setText(name);
    }
}
