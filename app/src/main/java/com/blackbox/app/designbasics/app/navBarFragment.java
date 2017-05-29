package com.blackbox.app.designbasics.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackbox.app.designbasics.R;
import com.blackbox.app.designbasics.adapters.navBarAdapter;
import com.blackbox.app.designbasics.model.nav_item;

/**
 * Created by Raghav on 30-May-17.
 */

public class navBarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.nav_bar,container,false);

        setUpRecycler(view);

        return view;
    }

    private void setUpRecycler(View view) {

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.drawerList);
        navBarAdapter adapter = new navBarAdapter(getActivity(), nav_item.getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



    }


}
