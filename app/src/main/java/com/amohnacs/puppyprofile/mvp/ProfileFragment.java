package com.amohnacs.puppyprofile.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amohnacs.common.MvpFragment;
import com.amohnacs.model.Profile;
import com.amohnacs.puppyprofile.R;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends MvpFragment<MainPresenter, MvpContract.View> implements MvpContract.View{
    private static final String TAG = ProfileFragment.class.getSimpleName();

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private MainPresenter presenter;
    private List<Profile> profiles = new ArrayList<>();
    private RecyclerView.Adapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProfileFragment() {
    }


    public static ProfileFragment newInstance(int columnCount) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = MainPresenter.getInstance(getActivity());
        presenter.loadProfiles();

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            //adapter = new ProfileAdapter(profiles, context);

            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public MainPresenter getPresenter() {
        return presenter;
    }

    @Override
    public MvpContract.View getMvpView() {
        return this;
    }

    @Override
    public void updateProfiles(List<Profile> profileList) {
        profiles.addAll(profileList);

        if(adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showErrorState(String errorMessage) {
// TODO: 3/22/18
    }
}