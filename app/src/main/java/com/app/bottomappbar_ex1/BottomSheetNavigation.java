package com.app.bottomappbar_ex1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class BottomSheetNavigation extends BottomSheetDialogFragment {
    NavigationView navigationView;
    ViewGroup parentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);

        // setUp Id
        parentView = view.findViewById(R.id.parent);
        navigationView = view.findViewById(R.id.navigation_view);

        // This is use for set your menu original icon
        //navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav1:
                        showSnack("WORK");
                        return true;
                    case R.id.nav2:
                        showSnack("TIMELINE");
                        return true;
                    case R.id.nav3:
                        showSnack("LOGOUT");
                        return true;
                    default:
                        return true;
                }
            }
        });


        return view;
    }

    public void showSnack(final String msg) {

        Snackbar.make(parentView, msg, Snackbar.LENGTH_SHORT).setAnchorView(navigationView).show();

    }


}
