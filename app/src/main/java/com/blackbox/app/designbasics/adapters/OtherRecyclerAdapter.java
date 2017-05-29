package com.blackbox.app.designbasics.adapters;

import android.content.Context;
import android.os.Parcel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.model.Animal;

import java.util.List;

/**
 * Created by Raghav on 29-May-17.
 */

public class OtherRecyclerAdapter extends RecyclerView.Adapter<OtherViewHolder> {

    List<Animal> animalList;
    LayoutInflater inflater;

    public OtherRecyclerAdapter(Context context, List<Animal> list)
    {
        animalList = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public OtherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item2, parent, false);

        OtherViewHolder holder = new OtherViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(OtherViewHolder holder, int position) {

        Animal current  = animalList.get(position);
        holder.setData(current);

    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}
