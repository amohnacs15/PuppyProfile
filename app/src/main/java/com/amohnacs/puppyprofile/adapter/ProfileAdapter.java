package com.amohnacs.puppyprofile.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amohnacs.model.Profile;
import com.amohnacs.puppyprofile.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<Profile> mValues;
    private Context context;

    public ProfileAdapter(List<Profile> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_profile_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Profile profile = mValues.get(position);
        SimpleTarget betterTargetnew = new SimpleTarget<BitmapDrawable>() {
            @Override
            public void onResourceReady(@NonNull BitmapDrawable resource, @Nullable Transition<? super BitmapDrawable> transition) {
                holder.setProgressLoading(false);
                holder.setGravatarImageView(resource.getBitmap());
            }
        };

        if (profile != null) {


            Glide.with(context)
                    .load(profile.getProfileImage())
                    .into(betterTargetnew);


            holder.setDisplayTextView(profile.getDisplayName());

            if (profile.getBadgeCount() != null) {
                holder.setGoldTextView(String.valueOf(profile.getBadgeCount().getGold()));
                holder.setSilverTextView(String.valueOf(profile.getBadgeCount().getSilver()));
                holder.setBronzeTextView(String.valueOf(profile.getBadgeCount().getBronze()));
            }
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}

