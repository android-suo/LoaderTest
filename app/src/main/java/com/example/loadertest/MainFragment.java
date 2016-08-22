package com.example.loadertest;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/8/12.
 */
public class MainFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
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
        return new CursorLoader(getContext(),
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
