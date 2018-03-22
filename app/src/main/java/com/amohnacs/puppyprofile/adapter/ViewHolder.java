package com.amohnacs.puppyprofile.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.amohnacs.puppyprofile.R;

/**
 * Created by adrianmohnacs on 3/21/18.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    private final View mView;

    private ProgressBar progressBar;
    private final ImageView gravatarImageView;

    private final TextView displayTextView;
    private final TextView goldTextView;
    private final TextView silverTextView;
    private final TextView bronzeTextView;

    ViewHolder(View view) {
        super(view);
        mView = view;

        progressBar = view.findViewById(R.id.progress_spinner);
        gravatarImageView = view.findViewById(R.id.profile_imageView);

        displayTextView = view.findViewById(R.id.profile_username_textView);
        goldTextView = view.findViewById(R.id.gold_textView);
        silverTextView = view.findViewById(R.id.silver_textView);
        bronzeTextView = view.findViewById(R.id.bronze_textView);
    }

    void setProgressLoading(boolean isLoading) {
        progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }


    void setGravatarImageView(Bitmap imageBitmap) {
        gravatarImageView.setImageBitmap(imageBitmap);
    }

    void setDisplayTextView(String displayName) {
        displayTextView.setText(displayName);
    }

    void setGoldTextView(String goldPoints) {
        goldTextView.setText(goldPoints);
    }

    void setSilverTextView(String silverPoints) {
        silverTextView.setText(silverPoints);
    }

    void setBronzeTextView(String bronzePoints) {
        bronzeTextView.setText(bronzePoints);
    }
}