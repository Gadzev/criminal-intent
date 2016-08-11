package com.bignerdranch.android.criminalintent;


import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;


public class PhotoViewFragment extends DialogFragment {

    public static final String ARG_PATH = "path";

    public static PhotoViewFragment newInstance(File path) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PATH, path);
        PhotoViewFragment fragment = new PhotoViewFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.zoom_picture_view, null);

        File path = (File) getArguments().getSerializable(ARG_PATH);


        if(path.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(path.getAbsolutePath());
            ImageView zoomedPhoto = (ImageView) view.findViewById(R.id.zoom_photo_view);
            zoomedPhoto.setImageBitmap(bitmap);
        }

        return new android.support.v7.app.AlertDialog.Builder(getActivity()).setView(view).create();
    }
}
