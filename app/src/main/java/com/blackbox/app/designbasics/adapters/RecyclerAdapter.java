package com.blackbox.app.designbasics.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.model.Landscape;

import java.util.List;

/**
 *
 *
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {

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
        holder.setListeners();

    }

    @Override
    public int getItemCount() {
        return landscapeList.size();
    }

    private void removeItem(int position)
    {
        Log.i("YOYO1", "removeItem " + position);

        landscapeList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,landscapeList.size());
    }

    private void addItem(int position, Landscape item)
    {
        Log.i("YOYO", "addItem " + position);
        landscapeList.add(position, item);
        notifyItemInserted(position);
        notifyItemRangeChanged(position,landscapeList.size());
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView imgThumb, imgDelete, imgAdd;
        private int position;
        private Landscape current;

        void setData(Landscape current, int position) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            if(position%2 == 0)
                this.imgAdd.setImageResource(R.drawable.ic_search);
            else
                this.imgAdd.setImageResource(R.drawable.ic_make_copy);
            this.position = position;
            this.current = current;
        }

        CustomViewHolder(View itemView) {
            super(itemView);
            title       = (TextView)  itemView.findViewById(R.id.list_title);
            imgThumb    = (ImageView) itemView.findViewById(R.id.list_img);
            imgDelete   = (ImageView) itemView.findViewById(R.id.list_img_delete);
            imgAdd      = (ImageView) itemView.findViewById(R.id.list_img_add);
        }

        void setListeners() {

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeItem(position);
                }
            });

            imgAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItem(position, current);
                }
            });

        }
    }

}
