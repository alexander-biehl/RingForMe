package com.example.alexb.ringforme;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexb.ringforme.db.entity.User;
import com.example.alexb.ringforme.viewmodel.AddViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity {

    @BindView(R.id.personName)
    EditText userTextField;

    @BindView(R.id.personNumber)
    EditText userPhoneField;

    @BindView(R.id.fab_add)
    FloatingActionButton fab;

    @BindView(R.id.fab_back)
    FloatingActionButton backButton;

    @BindView(R.id.toolbar_add)
    Toolbar toolbar;

    /** View Model to handle adding users to db. */
    private AddViewModel addViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //method to bind the AddViewModel to this class' application context
        addViewModel = ViewModelProviders.of(this).get(AddViewModel.class);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                if (userTextField.getText() == null || userPhoneField.getText() == null) {
                    Toast.makeText(AddActivity.this, "Missing Fields", Toast.LENGTH_SHORT).show();
                } else {
                    addViewModel.add(new User(
                            userTextField.getText().toString(),
                            userPhoneField.getText().toString()
                    ));
                    finish();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
