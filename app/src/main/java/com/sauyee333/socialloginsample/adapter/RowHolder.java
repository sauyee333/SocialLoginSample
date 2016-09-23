package com.sauyee333.socialloginsample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sauyee333.socialloginsample.R;
import com.sauyee333.socialloginsample.listener.RowSelectListener;

/**
 * Created by sauyee on 21/9/16.
 */

public class RowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private RowSelectListener mListener;
    public TextView title;

    public RowHolder(View itemView, RowSelectListener listener) {
        super(itemView);
        mListener = listener;
        title = (TextView) itemView.findViewById(R.id.title);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onRowClick(getAdapterPosition());
        }
    }
}