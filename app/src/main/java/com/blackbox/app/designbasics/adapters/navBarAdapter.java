package com.blackbox.app.designbasics.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.model.nav_item;

import java.util.List;

/**
 * Created by Raghav on 30-May-17.
 */

public class navBarAdapter extends RecyclerView.Adapter<navBarAdapter.navHolder> {

    LayoutInflater layoutInflater;
    List<nav_item> list;

    public navBarAdapter(Context context, List<nav_item> l)
    {
        layoutInflater = LayoutInflater.from(context);
        list = l;
    }

    @Override
    public navHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.nav_item, parent, false);
        navHolder holder = new navHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(navHolder holder, int position) {

        nav_item current = list.get(position);
        holder.setData(current);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class navHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public navHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.nav_imgIcon);
            textView = (TextView) itemView.findViewById(R.id.nav_itemTitle);
        }

        public void setData(nav_item item)
        {
            imageView.setImageResource(item.getImg_id());
            textView.setText(item.getTitle());
        }
    }
}
