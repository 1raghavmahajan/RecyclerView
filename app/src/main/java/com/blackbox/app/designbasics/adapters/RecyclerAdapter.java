package com.blackbox.app.designbasics.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.model.Landscape;

import java.util.List;

/**
 *
 *
 */

public class RecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<Landscape> landscapeList;
    private LayoutInflater layoutInflater;

    public RecyclerAdapter(Context context, List<Landscape> list)
    {
        landscapeList = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.i("YOYO", "onCreateViewHolder");

        View view = layoutInflater.inflate(R.layout.list_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Log.i("YOYO", "onBindViewHolder " + position);

        Landscape currentObj = landscapeList.get(position);
        holder.setData(currentObj, position);

    }

    @Override
    public int getItemCount() {
        return landscapeList.size();
    }
}
