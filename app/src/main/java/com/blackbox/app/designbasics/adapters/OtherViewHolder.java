package com.blackbox.app.designbasics.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.model.Animal;
import com.blackbox.app.designbasics.model.Landscape;

/**
 * Created by Raghav on 29-May-17.
 */

class OtherViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    ImageView imgThumb;

    public OtherViewHolder(View itemView) {
        super(itemView);
        title       = (TextView)  itemView.findViewById(R.id.txv_row);
        imgThumb    = (ImageView) itemView.findViewById(R.id.img_row);
    }

    public void setData(Animal current) {
        this.title.setText(current.getTitle());
        this.imgThumb.setImageResource(current.getImageId());
    }
}
