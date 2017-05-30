package com.blackbox.app.designbasics.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.adapters.OtherRecyclerAdapter;
import com.blackbox.app.designbasics.adapters.RecyclerAdapter;
import com.blackbox.app.designbasics.model.Animal;
import com.blackbox.app.designbasics.model.Landscape;


public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    Toolbar toolbar;
    RecyclerView recyclerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        setUpDrawer();

        setUpRecyclerView();
    }

    private void setUpDrawer() {

        /**
         *  init the nav drawer class just like initialising a button or something
         *  but findFragmentById is a child of FragmentManager
         */
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drawer_fragment);

        /**
         * Now init the parent: Drawer layout
        */
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        /**
         * Set up drawer
         */
        drawerFragment.setUpDrawer(R.id.nav_drawer_fragment, drawerLayout, toolbar);


    }

    private void setUpToolbar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setSubtitle("Drawer");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        context = getApplicationContext();
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setOnMenuItemClickListener(MainActivity.this);

    }

    private void setUpRecyclerView() {

        OtherRecyclerAdapter recyclerAdapter = new OtherRecyclerAdapter(context, Animal.getData());

        recyclerView.setAdapter(recyclerAdapter);

        StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); // (int spanCount, int orientation)
        recyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

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
}
