package com.example.alexb.ringforme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.alexb.ringforme.view.RecyclerViewAdapter;
import com.example.alexb.ringforme.viewmodel.UserListViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RingActivity extends /*LifecycleActivity*/AppCompatActivity {

    @BindView(R.id.fab)
    FloatingActionButton fab;

   /* @BindView(R.id.recyclerView)
    RecyclerView recyclerView;*/

    /** ViewModel to handle retrieving information from the database. */
    //private UserListViewModel userListViewModel;
    /** RecyclerViewAdapter to handle watching and updating the list view. */
    //private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
               //         .setAction("Action", null).show();
                //TODO add user fragment transaction goes here
                /*getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_layout, AddFragment.newInstance(), "addFragment")
                        .addToBackStack(null)
                        .commit();*/
                startActivity(new Intent(RingActivity.this, AddActivity.class));
            }
        });

        /*if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_ring, RingActivityFragment.newInstance(), "userList")
                    .commit();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ring, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
