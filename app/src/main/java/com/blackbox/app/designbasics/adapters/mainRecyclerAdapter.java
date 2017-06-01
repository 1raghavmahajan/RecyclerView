package com.blackbox.app.designbasics.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.model.Animal;

import java.util.List;

public class mainRecyclerAdapter extends RecyclerView.Adapter<mainRecyclerAdapter.customViewHolder> {

    private List<Animal> animalList;
    private LayoutInflater inflater;

    public mainRecyclerAdapter(Context context, List<Animal> list)
    {
        animalList = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public customViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item2, parent, false);

        customViewHolder holder = new customViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(customViewHolder holder, int position) {

        Animal current  = animalList.get(position);
        holder.setData(current);

    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    class customViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imgThumb;

        customViewHolder(View itemView) {
            super(itemView);
            title       = (TextView)  itemView.findViewById(R.id.txv_row);
            imgThumb    = (ImageView) itemView.findViewById(R.id.img_row);
        }

        public void setData(Animal current) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageId());
        }
    }

}
