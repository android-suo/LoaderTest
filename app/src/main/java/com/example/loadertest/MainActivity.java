package com.example.loadertest;

import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private GridView gridView;
    private AudioAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportLoaderManager().initLoader(0, null, this);
        gridView = (GridView) findViewById(R.id.grd_audio);
        adapter = new AudioAdapter(this);
        gridView.setAdapter(adapter);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = new String[]{
                MediaStore.Audio.Media._ID,//id
                MediaStore.Audio.Media.DATA,//音乐数据
                MediaStore.Audio.Media.DISPLAY_NAME,//音乐名称
                MediaStore.Audio.Media.ALBUM,//专辑
                MediaStore.Audio.Media.ARTIST,//演唱者
                MediaStore.Audio.Media.DURATION,//时长
                MediaStore.Audio.Media.SIZE,//大小

        };
        return new CursorLoader(this,
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            do {
                String audioName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                String audioArtist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                Log.e("Audio", audioName + "---" + audioArtist);
            } while (cursor.moveToNext());
        }
        adapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);

    }
}
