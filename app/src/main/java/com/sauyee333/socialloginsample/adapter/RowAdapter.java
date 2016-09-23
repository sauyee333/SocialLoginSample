package com.sauyee333.socialloginsample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sauyee333.socialloginsample.R;
import com.sauyee333.socialloginsample.listener.RowSelectListener;
import com.sauyee333.socialloginsample.model.RowInfo;

import java.util.List;

/**
 * Created by sauyee on 21/9/16.
 */

public class RowAdapter extends RecyclerView.Adapter<RowHolder> {

    private List<RowInfo> mItemList;
    private RowSelectListener mListener;

    public RowAdapter(List<RowInfo> itemList, RowSelectListener listener) {
        this.mItemList = itemList;
        this.mListener = listener;
    }

    @Override
    public RowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_row_item, null);
        return new RowHolder(convertView, mListener);
    }

    @Override
    public void onBindViewHolder(RowHolder holder, int position) {
        final RowInfo itemInfo = mItemList.get(position);
        holder.title.setText(itemInfo.getTitle());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
