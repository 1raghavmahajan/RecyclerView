package com.blackbox.app.designbasics.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.model.Landscape;


class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    ImageView imgThumb, imgDelete, imgAdd;
    int position;
    Landscape current;

    public void setData(Landscape current, int position) {
        this.title.setText(current.getTitle());
        this.imgThumb.setImageResource(current.getImageID());
        this.position = position;
        this.current = current;
    }

    public CustomViewHolder(View itemView) {
        super(itemView);
        title       = (TextView)  itemView.findViewById(R.id.list_title);
        imgThumb    = (ImageView) itemView.findViewById(R.id.list_img);
        imgDelete   = (ImageView) itemView.findViewById(R.id.list_img_delete);
        imgAdd      = (ImageView) itemView.findViewById(R.id.list_img_add);
    }
}
