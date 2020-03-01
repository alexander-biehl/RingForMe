package com.example.alexb.ringforme.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexb.ringforme.R;
import com.example.alexb.ringforme.db.entity.User;

import java.util.List;


/**
 * Created by alexb on 9/1/2017.
 */

public class RecyclerViewAdapter extends
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<User> userList;
    private View.OnLongClickListener longClickListener;

    public RecyclerViewAdapter(List<User> userList,
                               View.OnLongClickListener longClickListener) {
        this.userList = userList;
        this.longClickListener = longClickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recycler_item, parent, false));*/
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder,
                                 int position) {
        User user = userList.get(position);
        holder.itemTextView.setText(user.getPhone());
        holder.nameTextView.setText(user.getName());

        holder.itemView.setTag(user);
        holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addUsers(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTextView;
        private TextView nameTextView;

        RecyclerViewHolder(View view) {
            super(view);
            itemTextView = (TextView) view.findViewById(R.id.itemTextView);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        }
    }
}
