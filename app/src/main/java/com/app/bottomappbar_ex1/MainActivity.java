package com.app.bottomappbar_ex1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FloatingActionButton fab;
    private View parentView;
    private BottomAppBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup Views ID
        parentView = findViewById(R.id.parent);
        bar = findViewById(R.id.bar);
        fab = findViewById(R.id.fab);

        // setUp bottomAppBar as action bar otherwise you won't be used onOptionsItemSelected method
        setSupportActionBar(bar);

        // setUp Fab ClickListener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnack("FAB");
            }
        });

        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetNavigation bottomSheetNavigation =
                        new BottomSheetNavigation();

                bottomSheetNavigation.show(getSupportFragmentManager(), "onClicked!");
            }
        });

    }

    public void showSnack(final String msg) {

        Snackbar.make(parentView, msg, Snackbar.LENGTH_SHORT).setAnchorView(fab.getVisibility() == View.VISIBLE ? fab : bar).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.edit:
                showSnack("EDIT");
                return true;

            case R.id.delete:
                showSnack("DELETE");
                return true;

            case R.id.like:
                showSnack("LIKE");
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

}
