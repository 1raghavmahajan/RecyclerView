package com.blackbox.app.designbasics.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.adapters.OtherRecyclerAdapter;
import com.blackbox.app.designbasics.adapters.RecyclerAdapter;
import com.blackbox.app.designbasics.model.Animal;
import com.blackbox.app.designbasics.model.Landscape;

public class MainActivity extends Activity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        context = getApplicationContext();
        toolbar.inflateMenu(R.menu.menu);


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.linearViewHorizontal:
                        LinearLayoutManager mLinearLayoutManagerHorizontal = new LinearLayoutManager(context);
                        mLinearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
                        recyclerView.setLayoutManager(mLinearLayoutManagerHorizontal);
                        break;

                    case R.id.linearViewVertical:
                        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(context);
                        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
                        break;
                    case R.id.gridView:
                        GridLayoutManager mGridLayoutManager = new GridLayoutManager(context, 2); // (Context context, int spanCount)
                        recyclerView.setLayoutManager(mGridLayoutManager);
                        break;
                    case R.id.staggeredViewHorizontal:
                        StaggeredGridLayoutManager mStaggeredHorizontalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL); // (int spanCount, int orientation)
                        recyclerView.setLayoutManager(mStaggeredHorizontalLayoutManager);
                        break;
                    case R.id.staggeredViewVertical:
                        StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); // (int spanCount, int orientation)
                        recyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);
                        break;
                }
                return true;
            }
        });

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(context, Landscape.getData());
        recyclerView.setAdapter(recyclerAdapter);

        LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(context);
        linearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setUpRecyclerView2() {

        OtherRecyclerAdapter recyclerAdapter = new OtherRecyclerAdapter(context, Animal.getData());

        recyclerView.setAdapter(recyclerAdapter);

        LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(context);
        linearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
