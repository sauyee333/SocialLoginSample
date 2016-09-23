package com.sauyee333.socialloginsample.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sauyee333.socialloginsample.R;
import com.sauyee333.socialloginsample.adapter.RowAdapter;
import com.sauyee333.socialloginsample.listener.MainListener;
import com.sauyee333.socialloginsample.listener.RowSelectListener;
import com.sauyee333.socialloginsample.model.RowInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sauyee on 21/9/16.
 */

public class MainFragment extends Fragment implements RowSelectListener {

    private static final int MAIN_ROW_FACEBOOK = 0;
    private static final int MAIN_ROW_TWITTER = 1;
    private static final int MAIN_ROW_SHARING = 2;

    @Bind(R.id.list)
    RecyclerView mRecyclerListView;

    private RowAdapter mAdapter;
    private MainListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        setupListConfig();
        showList();
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (MainListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement BrowseItemsListener");
        }
    }

    private void setupListConfig() {
        mRecyclerListView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerListView.setLayoutManager(layoutManager);
    }

    private void showList() {
        List<RowInfo> itemList = getMeList();

        mAdapter = new RowAdapter(itemList, MainFragment.this);
        mRecyclerListView.setAdapter(mAdapter);
    }

    private List<RowInfo> getMeList() {
        List<RowInfo> itemList = new ArrayList<>();
        itemList.add(new RowInfo(getResources().getString(R.string.facebook)));
        itemList.add(new RowInfo(getResources().getString(R.string.twitter)));
        itemList.add(new RowInfo(getResources().getString(R.string.sharing)));

        return itemList;
    }

    @Override
    public void onRowClick(int position) {
        switch (position) {
            case MAIN_ROW_FACEBOOK: {
                _Debug("facebook ssss");
                FacebookLoginFragment fragment = new FacebookLoginFragment();
                if (mListener != null) {
                    mListener.onShowFragment(fragment, false);
                }
            }
            break;
            case MAIN_ROW_TWITTER: {
            }
            break;
            case MAIN_ROW_SHARING: {
            }
            break;
        }
    }

    private static void _Debug(String str) {
        Log.d("widget", str);
    }
}
