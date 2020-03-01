package com.example.alexb.ringforme;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexb.ringforme.db.AppDatabase;
import com.example.alexb.ringforme.db.entity.User;
import com.example.alexb.ringforme.view.RecyclerViewAdapter;
import com.example.alexb.ringforme.viewmodel.UserListViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A placeholder fragment containing a simple view.
 */
public class RingActivityFragment extends Fragment implements
    View.OnLongClickListener{

    private UserListViewModel viewModel;
    private RecyclerViewAdapter recyclerViewAdapter;

    /** ButterKnife unbinder to nullify views on Fragment lifecycle change. */
    private Unbinder unbinder;

    /*@BindView(R.id.recyclerView)*/
    RecyclerView recyclerView;

    public RingActivityFragment() {
    }

    /**
     * Factory constructor method.  This is done because we need to
     * have an empty constructor for android lifecycle to call when
     * bringing stuff back.  This allows us to pass arguments to the
     * fragment if necessary
     *
     * @return RingActivityFragment frag The Fragment
     */
    public static RingActivityFragment newInstance() {
        RingActivityFragment frag = new RingActivityFragment();
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_ring, container, false);
        unbinder = ButterKnife.bind(this, view);
        final Activity activity = getActivity();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<User>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        recyclerView.setAdapter(recyclerViewAdapter);

        viewModel = ViewModelProviders.of(getActivity()).get(UserListViewModel.class);

        viewModel.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                recyclerViewAdapter.addUsers(users);
            }
        });
        return view;
    }

    @Override
    public boolean onLongClick(View view) {
        User user = (User) view.getTag();
        viewModel.deleteUser(user);
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //For butterknife fragment lifecycle management
        unbinder.unbind();
        AppDatabase.destroyInstance();
    }
}
